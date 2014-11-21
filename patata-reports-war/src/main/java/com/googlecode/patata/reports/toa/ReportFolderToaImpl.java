package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.ReportFolder;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportFolderView;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportFolderToaImpl extends AbsrtactToaImpl<ReportFolder, ReportFolderView, String, UUID>
        implements IReportFolderToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public ReportFolder createEntityInstance(ReportFolderView view) {
        return new ReportFolder();
    }

    @Override
    public ReportFolderView createViewInstance(ReportFolder entity) {
        return new ReportFolderView();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
