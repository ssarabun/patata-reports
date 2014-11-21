package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.ReportDataSource;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportDataSourceView;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public class ReportDataSourceToaImpl extends AbsrtactToaImpl<ReportDataSource, ReportDataSourceView, String, UUID>
        implements IReportDataSourceToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public ReportDataSource createEntityInstance(ReportDataSourceView view) {
        return new ReportDataSource();
    }

    @Override
    public ReportDataSourceView createViewInstance(ReportDataSource entity) {
        return new ReportDataSourceView();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
