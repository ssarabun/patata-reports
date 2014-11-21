package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.DataSource;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.DataSourceView;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public class DataSourceToaImpl extends AbsrtactToaImpl<DataSource, DataSourceView, String, UUID>
        implements IDataSourceToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public DataSource createEntityInstance(DataSourceView view) {
        return new DataSource();
    }

    @Override
    public DataSourceView createViewInstance(DataSource entity) {
        return new DataSourceView();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
