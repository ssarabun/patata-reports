package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.dto.ReportDataSourceView;
import com.googlecode.patata.reports.dto.ReportTemplateView;
import com.googlecode.patata.reports.service.api.IReportTemplateService;
import java.util.List;
import java.util.UUID;
import javax.inject.Inject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:patata-reports-test-properties-spring-context.xml",
    "classpath:patata-reports-spring-context.xml"
})
public class ReportTemplateServiceTest {

    @Inject
    private IReportTemplateService service;

    @Test
    public void testCRUD() {
        assertNotNull(service);

        UUID prevVersionId = null;
        String name = "name1";
        String content = "content1";
        UUID defaultDatasourceId = UUID.fromString("5afba5ff-be24-4777-b85d-7ef408c42bc1");
        //
        UUID newPrevVersionId = null;
        String newName = "name2";
        String newContent = "content2";
        UUID newDefaultDatasourceId = UUID.fromString("5afba5ff-be24-4777-b85d-7ef408c42bc2");


        //create and init view
        ReportTemplateView view = new ReportTemplateView();
        view.setPrevVersionId(prevVersionId);
        view.setName(name);
        view.setContent(content);
        view.setDefaultDatasourceId(defaultDatasourceId);

        List<ReportDataSourceView> dataSources = view.getReportDatasources();
        dataSources.add(new ReportDataSourceView("parameter1", UUID.fromString("5afba5ff-be24-4777-b85d-7ef408c42bc2")));


        //save view
        ReportTemplateView createdView = service.save(view);
        assertNotNull(createdView);
        assertNotNull(createdView.getId());

        assertNotNull(createdView.getCreated());
//        assertNotNull(createdView.getPrevVersionId());
        assertEquals(createdView.getPrevVersionId(), view.getPrevVersionId());
        assertNotNull(createdView.getName());
        assertEquals(createdView.getName(), view.getName());
        assertNotNull(createdView.getContent());
        assertEquals(createdView.getContent(), view.getContent());
        assertNotNull(createdView.getDefaultDatasourceId());
        assertEquals(createdView.getDefaultDatasourceId(), view.getDefaultDatasourceId());

        assertNotNull(createdView.getReportDatasources());
        assertFalse(createdView.getReportDatasources().isEmpty());
        for (ReportDataSourceView reportDataSource : createdView.getReportDatasources()) {
            assertNotNull(reportDataSource.getId());
            assertNotNull(reportDataSource.getParameterName());
            assertNotNull(reportDataSource.getDatasourceId());
        }

        //find view
        ReportTemplateView foundView = service.findOne(createdView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), createdView.getId());
        assertEquals(foundView.getCreated(), createdView.getCreated());
        assertEquals(foundView.getPrevVersionId(), createdView.getPrevVersionId());
        assertEquals(foundView.getName(), createdView.getName());
        assertEquals(foundView.getContent(), createdView.getContent());
        assertEquals(foundView.getDefaultDatasourceId(), createdView.getDefaultDatasourceId());


        //update view
        createdView.setPrevVersionId(newPrevVersionId);
        createdView.setName(newName);
        createdView.setContent(newContent);
        createdView.setDefaultDatasourceId(newDefaultDatasourceId);
        createdView.getReportDatasources().clear();

        ReportTemplateView updatedView = service.save(createdView);
        assertNotNull(updatedView);
        assertEquals(updatedView.getId(), createdView.getId());
        assertEquals(updatedView.getCreated(), createdView.getCreated());
        assertEquals(updatedView.getPrevVersionId(), createdView.getPrevVersionId());
        assertEquals(updatedView.getName(), createdView.getName());
        assertEquals(updatedView.getContent(), createdView.getContent());
        assertEquals(updatedView.getDefaultDatasourceId(), createdView.getDefaultDatasourceId());
        assertNotNull(updatedView.getReportDatasources());
        assertTrue(updatedView.getReportDatasources().isEmpty());


        //find view
        foundView = service.findOne(updatedView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), updatedView.getId());
        assertEquals(foundView.getCreated(), updatedView.getCreated());
        assertEquals(foundView.getPrevVersionId(), updatedView.getPrevVersionId());
        assertEquals(foundView.getName(), updatedView.getName());
        assertEquals(foundView.getContent(), updatedView.getContent());
        assertEquals(foundView.getDefaultDatasourceId(), updatedView.getDefaultDatasourceId());

        service.delete(foundView);
        foundView = service.findOne(updatedView.getId());
        assertNull(foundView);
    }
}
