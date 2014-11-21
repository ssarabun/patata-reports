package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportView;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportToaImpl extends AbsrtactToaImpl<Report, ReportView, String, UUID>
        implements IReportToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public Report createEntityInstance(ReportView view) {
        return new Report();
    }

    @Override
    public ReportView createViewInstance(Report entity) {
        return new ReportView();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
