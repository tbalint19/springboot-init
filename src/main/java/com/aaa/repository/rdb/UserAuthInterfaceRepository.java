package com.aaa.repository.rdb;

import com.aaa.model.entity.UserAuthInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserAuthInterfaceRepository extends JpaRepository<UserAuthInterface, Long> {

    void deleteAllByConfirmedAndCreatedAtIsBefore(Boolean confirmed, LocalDateTime date);

    Optional<UserAuthInterface> findByUsername(String credential);
}
