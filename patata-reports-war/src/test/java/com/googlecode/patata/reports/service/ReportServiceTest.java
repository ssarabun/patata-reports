package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.dto.ReportDto;
import com.googlecode.patata.reports.service.api.IReportService;
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
 * @date Aug 7, 2014
 */
//TODO @Ignore
//@Ignore
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:test-properties-application-context.xml",
    "classpath:application-context.xml"
})
public class ReportServiceTest {

    @Inject
    private IReportService service;

    @Test
    public void testCRUD() {
        assertNotNull(service);

        String name = "test1_report_name";
        UUID folderId = UUID.fromString("385f79d8-c062-409a-9fa9-979cdada3efe");
        UUID currentTemplateId = UUID.fromString("77664235-f139-4e7a-974a-567e064edc0b");
        //
        String newName = "test2_report_name";
        UUID newfolderId = UUID.fromString("385f79d8-c062-409a-9fa9-979cdada3efe");
        UUID newCurrentTemplateId = UUID.fromString("77664235-f139-4e7a-974a-567e064edc0b");


        //create and init view
        ReportDto view = new ReportDto();
        view.setName(name);
        view.setFolderId(folderId);
        view.setCurrentTemplateId(currentTemplateId);


        //save view
        ReportDto createdView = service.save(view);
        assertNotNull(createdView);
        assertNotNull(createdView.getId());

        assertNotNull(createdView.getName());
        assertEquals(createdView.getName(), view.getName());
        assertNotNull(createdView.getFolderId());
        assertEquals(createdView.getFolderId(), view.getFolderId());
        assertNotNull(createdView.getCurrentTemplateId());
        assertEquals(createdView.getCurrentTemplateId(), view.getCurrentTemplateId());

        //find view
        ReportDto foundView = service.findOne(createdView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), createdView.getId());
        assertEquals(foundView.getName(), createdView.getName());
        assertEquals(foundView.getFolderId(), createdView.getFolderId());
        assertEquals(foundView.getCurrentTemplateId(), createdView.getCurrentTemplateId());


        //update view
        createdView.setName(newName);
        createdView.setFolderId(newfolderId);
        createdView.setCurrentTemplateId(newCurrentTemplateId);

        ReportDto updatedView = service.save(createdView);
        assertNotNull(updatedView);
        assertEquals(updatedView.getId(), createdView.getId());
        assertEquals(updatedView.getName(), createdView.getName());
        assertEquals(updatedView.getFolderId(), createdView.getFolderId());
        assertEquals(updatedView.getCurrentTemplateId(), createdView.getCurrentTemplateId());


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
