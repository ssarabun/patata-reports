package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ExtendedReportDto;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 8, 2014
 */
public class ExtendedReportToaImpl extends AbsrtactToaImpl<Report, ExtendedReportDto, String, UUID>
        implements IExtendedReportToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public Report createEntityInstance(ExtendedReportDto view) {
        return new Report();
    }

    @Override
    public ExtendedReportDto createViewInstance(Report entity) {
        return new ExtendedReportDto();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
