package com.aaa.repository.rdb;

import com.aaa.model.entity.SendAttempt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SendAttemptRepository extends JpaRepository<SendAttempt, Long> {
}
