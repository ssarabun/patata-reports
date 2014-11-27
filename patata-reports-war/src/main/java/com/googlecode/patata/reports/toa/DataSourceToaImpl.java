package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.DataSource;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.DataSourceDto;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public class DataSourceToaImpl extends AbsrtactToaImpl<DataSource, DataSourceDto, String, UUID>
        implements IDataSourceToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public Class<DataSource> getEntityCLass() {
        return DataSource.class;
    }

    @Override
    public DataSource createEntityInstance(DataSourceDto view) {
        return new DataSource();
    }

    public Class<DataSourceDto> getDTOCLass() {
        return DataSourceDto.class;
    }

    @Override
    public DataSourceDto createViewInstance(DataSource entity) {
        return new DataSourceDto();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

}
