package com.aaa.repository.rdb;

import com.aaa.model.entity.GroupAuthInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<GroupAuthInterface, Long> {
}
