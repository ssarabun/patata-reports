package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ExtendedReportView;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 8, 2014
 */
public class ExtendedReportToaImpl extends AbsrtactToaImpl<Report, ExtendedReportView, String, UUID>
        implements IExtendedReportToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public Report createEntityInstance(ExtendedReportView view) {
        return new Report();
    }

    @Override
    public ExtendedReportView createViewInstance(Report entity) {
        return new ExtendedReportView();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
