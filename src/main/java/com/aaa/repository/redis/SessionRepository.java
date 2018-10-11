package com.aaa.repository.redis;

import com.aaa.model.entity.Session;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface SessionRepository extends CrudRepository<Session, String> {

    Optional<Session> findBySessionId(String sessionId);

    List<Session> findByUserId(Long userId);

    List<Session> findAll();

    void deleteBySessionId(String sessionId);

    void deleteAllByCreatedAtBefore(LocalDateTime localDateTime);
}
