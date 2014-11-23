package com.googlecode.report.service.service;

import com.googlecode.report.service.view.ExtendedReportView;
import com.googlecode.report.service.view.ReportTemplateView;
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
 * @date Aug 8, 2014
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:reportservice-test-properties-spring-context.xml",
    "classpath:reportservice-spring-context.xml"
})
public class ExtendedReportServiceTest {

    @Inject
    private IExtendedReportService service;

    @Test
    public void testCRUD() {
        assertNotNull(service);

        String name = "test1_report_name";
        UUID folderId = UUID.fromString("385f79d8-c062-409a-9fa9-979cdada3efe");
        String templateName = "name1";
        String templateContent = "content1";
        UUID defaultDatasourceId = UUID.fromString("5afba5ff-be24-4777-b85d-7ef408c42bc1");
        //
        String newName = "test2_report_name";
        UUID newfolderId = UUID.fromString("385f79d8-c062-409a-9fa9-979cdada3efe");
        String newTemplateName = "name2";
        String newTemplateContent = "content2";
        UUID newDefaultDatasourceId = UUID.fromString("5afba5ff-be24-4777-b85d-7ef408c42bc2");


        //create and init view
        ExtendedReportView view = new ExtendedReportView();
        view.setName(name);
        view.setFolderId(folderId);
        ReportTemplateView template = new ReportTemplateView();
        template.setName(templateName);
        template.setContent(templateContent);
        template.setDefaultDatasourceId(defaultDatasourceId);
        view.setCurrentTemplate(template);



        //save view
        ExtendedReportView createdView = service.save(view);
        assertNotNull(createdView);
        assertNotNull(createdView.getId());

        assertNotNull(createdView.getName());
        assertEquals(createdView.getName(), view.getName());
        assertNotNull(createdView.getFolderId());
        assertEquals(createdView.getFolderId(), view.getFolderId());
        assertNotNull(createdView.getCurrentTemplateId());
        assertNotNull(createdView.getCurrentTemplate());
        assertNotNull(createdView.getCurrentTemplate().getId());
        assertNotNull(createdView.getCurrentTemplate().getCreated());
        assertEquals(createdView.getCurrentTemplate().getName(), view.getCurrentTemplate().getName());
        assertEquals(createdView.getCurrentTemplate().getContent(), view.getCurrentTemplate().getContent());
        assertEquals(createdView.getCurrentTemplate().getDefaultDatasourceId(), view.getCurrentTemplate().getDefaultDatasourceId());

        //find view
        ExtendedReportView foundView = service.findOne(createdView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), createdView.getId());
        assertEquals(foundView.getName(), createdView.getName());
        assertEquals(foundView.getFolderId(), createdView.getFolderId());
        assertNotNull(foundView.getCurrentTemplateId());


        //update view
        createdView.setName(newName);
        createdView.setFolderId(newfolderId);
        template = new ReportTemplateView();
        template.setName(newTemplateName);
        template.setContent(newTemplateContent);
        template.setDefaultDatasourceId(newDefaultDatasourceId);
        createdView.setCurrentTemplate(template);

        ExtendedReportView updatedView = service.save(createdView);
        assertNotNull(updatedView);
        assertEquals(updatedView.getId(), createdView.getId());
        assertEquals(updatedView.getName(), createdView.getName());
        assertEquals(updatedView.getFolderId(), createdView.getFolderId());
        assertNotNull(updatedView.getCurrentTemplateId());
        assertNotNull(updatedView.getCurrentTemplate());
        assertNotNull(updatedView.getCurrentTemplate().getId());
        assertNotNull(updatedView.getCurrentTemplate().getCreated());
        assertEquals(updatedView.getCurrentTemplate().getName(), createdView.getCurrentTemplate().getName());
        assertEquals(updatedView.getCurrentTemplate().getContent(), createdView.getCurrentTemplate().getContent());
        assertEquals(updatedView.getCurrentTemplate().getDefaultDatasourceId(), createdView.getCurrentTemplate().getDefaultDatasourceId());


        //find view
        foundView = service.findOne(updatedView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), updatedView.getId());
        assertEquals(foundView.getName(), updatedView.getName());
        assertEquals(foundView.getFolderId(), updatedView.getFolderId());
        assertEquals(foundView.getCurrentTemplateId(), updatedView.getCurrentTemplateId());

        service.delete(foundView);
        foundView = service.findOne(updatedView.getId());
        assertNull(foundView);
    }
}
