package com.aaa.repository.rdb;

import com.aaa.model.entity.AuthEntityConfirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface AuthEntityConfirmationRepository extends JpaRepository<AuthEntityConfirmation, Long> {

    void deleteAllByUsedAndCreatedAtBefore(Boolean used, LocalDateTime localDateTime);
}
