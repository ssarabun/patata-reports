package com.googlecode.patata.reports.web.pages;

import com.googlecode.patata.reports.dto.DataSourceDto;
import com.googlecode.patata.reports.service.api.IDataSourceService;
import com.googlecode.patata.reports.web.utils.DataSourceGridDataSource;
import com.googlecode.patata.reports.web.view.VDataSource;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataSource {

    private static final Logger logger = LoggerFactory.getLogger(DataSource.class);
    @javax.inject.Inject
    private IDataSourceService dataSourceService;
    @Inject
    private Block view, edit;
    @Property
    @Persist
    private DataSourceGridDataSource source;
    @Property
    @Persist
    private DataSourceDto dataSource;
    @Persist
    private boolean editMode;

    void setupRender() {
        logger.info("void setupRender()");
        source = new DataSourceGridDataSource(dataSourceService);
    }

    boolean beginRender(MarkupWriter writer) throws Exception {
        logger.info("boolean beginRender(MarkupWriter writer)");
        System.out.println("dataSourceService = " + dataSourceService);
        return true;
    }

    void onActionFromNew() {
        editMode = true;
        dataSource = new DataSourceDto();
    }

    void onSuccess() {
        dataSourceService.save(dataSource);
        dataSource = null;
        editMode = false;
    }

    public Object getActiveBlock() {
        return editMode ? edit : view;
    }
}
