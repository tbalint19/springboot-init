package com.aaa.repository.rdb;

import com.aaa.model.entity.DomainPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainPermissionRepository extends JpaRepository<DomainPermission, Long> {
}
