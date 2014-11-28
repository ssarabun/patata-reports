package com.googlecode.patata.reports.service.impl;

import com.googlecode.patata.reports.dto.ExtendedReportDto;
import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.model.ReportTemplate;
import com.googlecode.patata.reports.repository.IReportRepository;
import com.googlecode.patata.reports.service.IExtendedReportService;
import com.googlecode.patata.reports.service.spi.AbstractServiceImpl;
import com.googlecode.patata.reports.toa.IExtendedReportToa;
import com.googlecode.patata.reports.toa.IReportTemplateToa;
import java.util.Map;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author ssarabun
 */
public class ExtendedReportServiceImpl extends AbstractServiceImpl<ExtendedReportDto, Report, String, UUID>
        implements IExtendedReportService {

    @Inject
    private IExtendedReportToa toa;
    @Inject
    private IReportTemplateToa reportTemplateToa;
    @Inject
    private IReportRepository repository;

    @Override
    protected void beforeSave(ExtendedReportDto view, Report entity, Map<Object, Object> params) {
        if (view.getCurrentTemplate().getId() == null) {
            ReportTemplate currentTemplate = entity.getCurrentTemplate();
            if (currentTemplate != null) {
                currentTemplate.setReport(entity);
                entity.getReportTemplates().add(currentTemplate);
            }

            ReportTemplate newTemplate = new ReportTemplate();
            reportTemplateToa.merge(newTemplate, view.getCurrentTemplate());
            newTemplate.setPrevVersion(currentTemplate);
            entity.setCurrentTemplate(newTemplate);
        }
    }

    @Override
    protected IReportRepository getRepository() {
        return repository;
    }

    @Override
    protected IExtendedReportToa getToa() {
        return toa;
    }

}
