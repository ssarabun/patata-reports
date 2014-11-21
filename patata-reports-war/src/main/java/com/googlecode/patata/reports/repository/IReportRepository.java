package com.googlecode.patata.reports.repository;

import com.googlecode.patata.reports.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public interface IReportRepository extends JpaRepository<Report, String> {
}
