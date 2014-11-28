package com.googlecode.patata.reports.repository;

import com.googlecode.patata.reports.model.ReportFolder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public interface IReportFolderRepository extends JpaRepository<ReportFolder, String> {
}
