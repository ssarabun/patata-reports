package com.googlecode.patata.reports.repository;

import com.googlecode.patata.reports.model.ReportTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public interface IReportTemplateRepository extends JpaRepository<ReportTemplate, String> {
}
