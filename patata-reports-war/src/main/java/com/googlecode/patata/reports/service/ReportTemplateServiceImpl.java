package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.dto.ReportTemplateView;
import com.googlecode.patata.reports.model.ReportTemplate;
import com.googlecode.patata.reports.repository.IReportTemplateRepository;
import com.googlecode.patata.reports.service.api.IReportTemplateService;
import com.googlecode.patata.reports.service.spi.AbstractServiceImpl;
import com.googlecode.patata.reports.toa.IReportTemplateToa;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author ssarabun
 */
public class ReportTemplateServiceImpl extends AbstractServiceImpl<ReportTemplateView, ReportTemplate, String, UUID>
        implements IReportTemplateService {

    @Inject
    private IReportTemplateRepository repository;
    @Inject
    private IReportTemplateToa toa;

    @Override
    protected IReportTemplateRepository getRepository() {
        return repository;
    }

    @Override
    protected IReportTemplateToa getToa() {
        return toa;
    }

}
