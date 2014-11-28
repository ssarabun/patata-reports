package com.googlecode.patata.reports.web.pages;

import com.googlecode.patata.reports.dto.DataSourceDto;
import com.googlecode.patata.reports.service.api.IDataSourceService;
import com.googlecode.patata.reports.web.utils.DataSourceGridDataSource;
import java.util.UUID;
import javax.inject.Inject;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSource extends AbstractCrud<UUID, DataSourceDto, IDataSourceService> {

    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);
    @Inject
    private IDataSourceService dataSourceService;
    @Property
    @Persist
    private DataSourceGridDataSource source;

    void setupRender() {
        logger.info("void setupRender()");
        source = new DataSourceGridDataSource(dataSourceService);
    }

    boolean beginRender(MarkupWriter writer) throws Exception {
        logger.info("boolean beginRender(MarkupWriter writer)");
        return true;
    }

    @Override
    protected DataSourceDto createDto() {
        return new DataSourceDto();
    }

    @Override
    protected IDataSourceService getService() {
        return dataSourceService;
    }

    @Override
    protected UUID convert(String id) {
        return UUID.fromString(id);
    }
}
