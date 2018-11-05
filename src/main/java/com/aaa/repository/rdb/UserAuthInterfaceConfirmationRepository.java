package com.aaa.repository.rdb;

import com.aaa.model.entity.UserAuthInterfaceConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface UserAuthInterfaceConfirmationRepository extends JpaRepository<UserAuthInterfaceConfirmation, Long> {

    void deleteAllByUsedAndCreatedAtBefore(Boolean used, LocalDateTime localDateTime);
}
