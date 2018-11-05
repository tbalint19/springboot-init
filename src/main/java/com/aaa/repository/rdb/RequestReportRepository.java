package com.aaa.repository.rdb;

import com.aaa.model.entity.RequestReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestReportRepository extends JpaRepository<RequestReport, Long> {
}
