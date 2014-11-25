package com.googlecode.patata.reports.utils.mapper;

import com.googlecode.patata.reports.utils.mapper.spi.AbstractCustomConverter;
import com.googlecode.patata.reports.model.DataSource;
import com.googlecode.patata.reports.repository.IDataSourceRepository;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.DataSourceDto;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class DataSourceToUUIDConverter extends AbstractCustomConverter<DataSource, DataSourceDto, String, UUID>
        implements IDataSourceToUUIDConverter {

    @Inject
    private IDataSourceRepository repository;
    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public DataSourceToUUIDConverter() {
        super(UUID.class, DataSource.class);
    }

    @Override
    public IDataSourceRepository getRepository() {
        return repository;
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

    @Override
    public String getConverterName() {
        return "DataSourceToUUIDConverter";
    }
}
