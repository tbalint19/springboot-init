package com.aaa.repository.rdb;

import com.aaa.model.entity.DomainRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainRoleRepository extends JpaRepository<DomainRole, Long> {
}
