package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.service.spi.BaseService;
import com.googlecode.patata.reports.dto.ReportFolderDto;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public interface IReportFolderService extends BaseService<ReportFolderDto, UUID> {

    ReportFolderDto getRootReportFolder();
}
