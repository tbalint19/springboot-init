package com.aaa.repository.rdb;

import com.aaa.model.entity.DomainPermission;
import com.aaa.model.entity.GroupPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupPermissionRepository extends JpaRepository<GroupPermission, Long> {
}
