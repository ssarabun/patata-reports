package com.googlecode.patata.reports.toa.impl;

import com.googlecode.patata.reports.toa.spi.AbsrtactToaImpl;
import com.googlecode.patata.reports.model.ReportDataSource;
import com.googlecode.patata.reports.model.ReportTemplate;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportDataSourceDto;
import com.googlecode.patata.reports.dto.ReportTemplateDto;
import com.googlecode.patata.reports.toa.IReportTemplateToa;
import java.util.Collection;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class ReportTemplateToaImpl extends AbsrtactToaImpl<ReportTemplate, ReportTemplateDto, String, UUID>
        implements IReportTemplateToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public boolean merge(ReportTemplate entity, ReportTemplateDto view) {

        boolean rc = super.merge(entity, view);
        mergeReportDataSource(entity, view);
        return rc;
    }

    private void mergeReportDataSource(final ReportTemplate entity, ReportTemplateDto view) {

        Collection<ReportDataSourceDto> views = view.getReportDatasources();
        Collection<ReportDataSource> entities = entity.getReportDataSources();

        mergeCollection(views, entities, new MergeCollectionCallBack<ReportDataSource, ReportDataSourceDto, String, UUID>() {
            @Override
            public ReportDataSource createEntity(ReportDataSourceDto view) {
                return new ReportDataSource();
            }

            @Override
            public void beforeSave(ReportDataSource subEntity, ReportDataSourceDto subView) {
                subEntity.setReportTemplate(entity);
            }

            @Override
            public String convertId(UUID id) {
                return identifierConvertor.convertViewId(id);
            }
        });
    }

    public Class<ReportTemplate> getEntityCLass() {
        return ReportTemplate.class;
    }

    @Override
    public ReportTemplate createEntityInstance(ReportTemplateDto view) {
        return new ReportTemplate();
    }

    public Class<ReportTemplateDto> getDTOCLass() {
        return ReportTemplateDto.class;
    }

    @Override
    public ReportTemplateDto createViewInstance(ReportTemplate entity) {
        return new ReportTemplateDto();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

}
