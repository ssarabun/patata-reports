package com.googlecode.report.service.service;

import com.googlecode.report.service.view.ReportFolderView;
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
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:reportservice-test-properties-spring-context.xml",
    "classpath:reportservice-spring-context.xml"
})
public class ReportFolderServiceTest {

    @Inject
    private IReportFolderService service;

    @Test
    public void testCRUD() {
        assertNotNull(service);

        String name = "test1_folder_name";
        UUID parentId = null;
        //
        String newName = "test2_folder_name";
        UUID newParentId = UUID.fromString("385f79d8-c062-409a-9fa9-979cdada3efe");


        //create and init view
        ReportFolderView view = new ReportFolderView();
        view.setName(name);
        view.setParentId(parentId);


        //save view
        ReportFolderView createdView = service.save(view);
        assertNotNull(createdView);
        assertNotNull(createdView.getId());

        assertNotNull(createdView.getName());
        assertEquals(createdView.getName(), view.getName());
        assertEquals(createdView.getParentId(), view.getParentId());

        //find view
        ReportFolderView foundView = service.findOne(createdView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), createdView.getId());
        assertEquals(foundView.getName(), createdView.getName());
        assertEquals(foundView.getParentId(), createdView.getParentId());


        //update view
        createdView.setName(newName);
        createdView.setParentId(newParentId);

        ReportFolderView updatedView = service.save(createdView);
        assertNotNull(updatedView);
        assertEquals(updatedView.getId(), createdView.getId());
        assertEquals(updatedView.getName(), createdView.getName());
        assertEquals(updatedView.getParentId(), createdView.getParentId());


        //find view
        foundView = service.findOne(updatedView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), updatedView.getId());
        assertEquals(foundView.getName(), updatedView.getName());
        assertEquals(foundView.getParentId(), updatedView.getParentId());

        service.delete(foundView);
        foundView = service.findOne(updatedView.getId());
        assertNull(foundView);
    }
}
