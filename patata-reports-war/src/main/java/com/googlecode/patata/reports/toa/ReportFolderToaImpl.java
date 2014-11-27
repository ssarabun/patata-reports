package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.ReportFolder;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportFolderDto;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportFolderToaImpl extends AbsrtactToaImpl<ReportFolder, ReportFolderDto, String, UUID>
        implements IReportFolderToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public Class<ReportFolder> getEntityCLass() {
        return ReportFolder.class;
    }

    @Override
    public ReportFolder createEntityInstance(ReportFolderDto view) {
        return new ReportFolder();
    }

    public Class<ReportFolderDto> getDTOCLass() {
        return ReportFolderDto.class;
    }

    @Override
    public ReportFolderDto createViewInstance(ReportFolder entity) {
        return new ReportFolderDto();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
