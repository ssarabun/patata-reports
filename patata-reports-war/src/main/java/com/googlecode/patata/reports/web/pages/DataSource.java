package com.googlecode.patata.reports.web.pages;

import com.googlecode.patata.reports.service.api.IDataSourceService;
import com.googlecode.patata.reports.web.utils.DataSourceGridDataSource;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Property;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSource {

    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);
    @javax.inject.Inject
    private IDataSourceService dataSourceService;
    @Property
    private DataSourceGridDataSource source;

    void setupRender() {
        logger.info("void setupRender()");
        source = new DataSourceGridDataSource(dataSourceService);
    }

    boolean beginRender(MarkupWriter writer) throws Exception {
        logger.info("boolean beginRender(MarkupWriter writer)");
        System.out.println("dataSourceService = " + dataSourceService);
        return true;
    }
}
