package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.ReportDataSource;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportDataSourceDto;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public class ReportDataSourceToaImpl extends AbsrtactToaImpl<ReportDataSource, ReportDataSourceDto, String, UUID>
        implements IReportDataSourceToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public Class<ReportDataSource> getEntityCLass() {
        return ReportDataSource.class;
    }

    @Override
    public ReportDataSource createEntityInstance(ReportDataSourceDto view) {
        return new ReportDataSource();
    }

    public Class<ReportDataSourceDto> getDTOCLass() {
        return ReportDataSourceDto.class;
    }

    @Override
    public ReportDataSourceDto createViewInstance(ReportDataSource entity) {
        return new ReportDataSourceDto();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

}
