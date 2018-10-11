package com.aaa.repository.rdb;

import com.aaa.model.entity.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long> {

    void deleteAllByUsedAndCreatedAtBefore(Boolean used, LocalDateTime localDateTime);
}
