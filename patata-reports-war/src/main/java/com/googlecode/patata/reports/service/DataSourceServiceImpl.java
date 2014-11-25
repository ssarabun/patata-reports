package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.dto.DataSourceDto;
import com.googlecode.patata.reports.model.DataSource;
import com.googlecode.patata.reports.repository.IDataSourceRepository;
import com.googlecode.patata.reports.service.api.IDataSourceService;
import com.googlecode.patata.reports.service.spi.AbstractServiceImpl;
import com.googlecode.patata.reports.toa.IDataSourceToa;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author ssarabun
 */
public class DataSourceServiceImpl extends AbstractServiceImpl<DataSourceDto, DataSource, String, UUID>
        implements IDataSourceService {

    @Inject
    private IDataSourceToa toa;

    @Inject
    private IDataSourceRepository repository;

    @Override
    protected IDataSourceRepository getRepository() {
        return repository;
    }

    @Override
    protected IDataSourceToa getToa() {
        return toa;
    }

}
