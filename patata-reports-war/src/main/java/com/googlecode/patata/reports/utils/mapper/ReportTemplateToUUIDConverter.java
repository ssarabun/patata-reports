package com.googlecode.patata.reports.utils.mapper;

import com.googlecode.patata.reports.utils.mapper.spi.AbstractCustomConverter;
import com.googlecode.patata.reports.model.ReportTemplate;
import com.googlecode.patata.reports.repository.IReportTemplateRepository;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportTemplateView;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class ReportTemplateToUUIDConverter extends AbstractCustomConverter<ReportTemplate, ReportTemplateView, String, UUID>
        implements IReportTemplateToUUIDConverter {

    @Inject
    private IReportTemplateRepository repository;
    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public ReportTemplateToUUIDConverter() {
        super(UUID.class, ReportTemplate.class);
    }

    @Override
    public IReportTemplateRepository getRepository() {
        return repository;
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

    @Override
    public String getConverterName() {
        return "ReportTemplateToUUIDConverter";
    }
}
