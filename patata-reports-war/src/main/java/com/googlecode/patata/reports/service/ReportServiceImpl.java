package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.dto.ReportDto;
import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.repository.IReportRepository;
import com.googlecode.patata.reports.service.api.IReportService;
import com.googlecode.patata.reports.service.spi.AbstractServiceImpl;
import com.googlecode.patata.reports.toa.IReportToa;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author ssarabun
 */
public class ReportServiceImpl extends AbstractServiceImpl<ReportDto, Report, String, UUID>
        implements IReportService {

    @Inject
    private IReportRepository repository;
    @Inject
    private IReportToa toa;

    @Override
    protected IReportRepository getRepository() {
        return repository;
    }

    @Override
    protected IReportToa getToa() {
        return toa;
    }

}
