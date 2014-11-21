package com.googlecode.patata.reports.repository;

import com.googlecode.patata.reports.model.ReportDataSource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public interface IReportDataSourceRepository extends JpaRepository<ReportDataSource, String> {
}
