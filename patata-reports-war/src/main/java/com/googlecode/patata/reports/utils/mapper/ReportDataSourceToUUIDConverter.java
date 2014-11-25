package com.googlecode.patata.reports.utils.mapper;

import com.googlecode.patata.reports.utils.mapper.spi.AbstractCustomConverter;
import com.googlecode.patata.reports.model.ReportDataSource;
import com.googlecode.patata.reports.repository.IReportDataSourceRepository;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportDataSourceDto;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class ReportDataSourceToUUIDConverter extends AbstractCustomConverter<ReportDataSource, ReportDataSourceDto, String, UUID>
        implements IReportDataSourceToUUIDConverter {

    @Inject
    private IReportDataSourceRepository repository;
    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public ReportDataSourceToUUIDConverter() {
        super(UUID.class, ReportDataSource.class);
    }

    @Override
    public IReportDataSourceRepository getRepository() {
        return repository;
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

    @Override
    public String getConverterName() {
        return "ReportDataSourceToUUIDConverter";
    }
}
