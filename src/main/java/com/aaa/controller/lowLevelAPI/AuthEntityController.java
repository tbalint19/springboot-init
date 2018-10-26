package com.aaa.controller.lowLevelAPI;

import com.aaa.model.dto.StatusResponse;
import com.aaa.model.entity.AuthEntity;
import com.aaa.model.entity.AuthEntityConfirmation;
import com.aaa.repository.rdb.AuthEntityRepository;
import com.aaa.service.AuthEntityService;
import com.aaa.service.ConfirmationService;
import com.aaa.service.HashService;
import com.aaa.service.TimeService;
import com.aaa.util.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entity")
public class AuthEntityController {

    private HashService hash;
    private TimeService time;
    private AuthEntityService authEntityService;
    private ConfirmationService confirmationService;

    @Autowired
    public AuthEntityController(
            HashService hashService, TimeService timeService, ConfirmationService confirmationService) {
        this.hash = hashService;
        this.time = timeService;
        this.confirmationService = confirmationService;
    }

    @PostMapping("/create")
    public StatusResponse create(
            @RequestParam Boolean withConfirm,
            @RequestParam Boolean withPassword,
            @RequestParam Boolean withEmail,
            @RequestParam Boolean active,
            AuthEntity authEntity) {

        if (withEmail && authEntity.getEmail() == null)
            return new StatusResponse(false);

        if (withPassword && authEntity.getPassword() == null)
            return new StatusResponse(false);

        authEntity.setPassword(hash.create(authEntity.getPassword()));
        authEntity.setCreatedAt(time.getNow());
        authEntityService.save(authEntity);

        if (withConfirm) {
            AuthEntityConfirmation confirmation = confirmationService.create(authEntity);
            confirmationService.save(confirmation);
        } else {

        }

        return new StatusResponse(true);
    }
}
