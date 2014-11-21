package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.ReportDataSource;
import com.googlecode.patata.reports.model.ReportTemplate;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportDataSourceView;
import com.googlecode.patata.reports.dto.ReportTemplateView;
import java.util.Collection;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class ReportTemplateToaImpl extends AbsrtactToaImpl<ReportTemplate, ReportTemplateView, String, UUID>
        implements IReportTemplateToa {

    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    @Override
    public boolean merge(ReportTemplate entity, ReportTemplateView view) {

        boolean rc = super.merge(entity, view);
        mergeReportDataSource(entity, view);
        return rc;
    }

    private void mergeReportDataSource(final ReportTemplate entity, ReportTemplateView view) {

        Collection<ReportDataSourceView> views = view.getReportDatasources();
        Collection<ReportDataSource> entities = entity.getReportDataSources();

        mergeCollection(views, entities, new MergeCollectionCallBack<ReportDataSource, ReportDataSourceView, String, UUID>() {
            @Override
            public ReportDataSource createEntity(ReportDataSourceView view) {
                return new ReportDataSource();
            }

            @Override
            public void beforeSave(ReportDataSource subEntity, ReportDataSourceView subView) {
                subEntity.setReportTemplate(entity);
            }

            @Override
            public String convertId(UUID id) {
                return identifierConvertor.convertViewId(id);
            }
        });
    }

    @Override
    public ReportTemplate createEntityInstance(ReportTemplateView view) {
        return new ReportTemplate();
    }

    @Override
    public ReportTemplateView createViewInstance(ReportTemplate entity) {
        return new ReportTemplateView();
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }
}
