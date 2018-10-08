package com.aaa.repository.rdb;

import com.aaa.model.entity.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthEntityRepository extends JpaRepository<AuthEntity, Long> {
}
