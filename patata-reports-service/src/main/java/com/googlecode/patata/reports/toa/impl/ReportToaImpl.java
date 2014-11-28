package com.googlecode.patata.reports.toa.impl;

import com.googlecode.patata.reports.toa.spi.AbsrtactToaImpl;
import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportDto;
import com.googlecode.patata.reports.toa.IReportToa;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportToaImpl extends AbsrtactToaImpl<Report, ReportDto, String, UUID>
        implements IReportToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public Class<Report> getEntityCLass() {
        return Report.class;
    }

    @Override
    public Report createEntityInstance(ReportDto view) {
        return new Report();
    }

    public Class<ReportDto> getDTOCLass() {
        return ReportDto.class;
    }

    @Override
    public ReportDto createViewInstance(Report entity) {
        return new ReportDto();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

}
