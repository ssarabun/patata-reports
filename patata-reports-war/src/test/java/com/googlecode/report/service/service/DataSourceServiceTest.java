package com.googlecode.report.service.service;

import com.googlecode.report.service.view.DataSourceView;
import javax.inject.Inject;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration({
    "classpath:reportservice-test-properties-spring-context.xml",
    "classpath:reportservice-spring-context.xml"
})
public class DataSourceServiceTest {

    @Inject
    private IDataSourceService service;

    @Test
    public void testCRUD() {
        assertNotNull(service);

        String jndiName = "java:testDS";
        String name = "testName1";
        String description = "description1";
        //
        String newJndiName = "java:newTestDS";
        String newName = "testName2";
        String newDescription = "description1";


        //create and init view
        DataSourceView view = new DataSourceView();
        view.setJndiName(jndiName);
        view.setName(name);
        view.setDescription(description);


        //save view
        DataSourceView createdView = service.save(view);
        assertNotNull(createdView);
        assertNotNull(createdView.getId());
        System.out.println("createdView = " + createdView);

        assertNotNull(createdView.getJndiName());
        assertEquals(createdView.getJndiName(), view.getJndiName());
        assertNotNull(createdView.getName());
        assertEquals(createdView.getName(), view.getName());
        assertNotNull(createdView.getDescription());
        assertEquals(createdView.getDescription(), view.getDescription());

        //find view
        DataSourceView foundView = service.findOne(createdView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), createdView.getId());
        assertEquals(foundView.getJndiName(), createdView.getJndiName());
        assertEquals(foundView.getName(), createdView.getName());
        assertEquals(foundView.getDescription(), createdView.getDescription());


        //update view
        createdView.setJndiName(newJndiName);
        createdView.setName(newName);
        createdView.setDescription(newDescription);

        DataSourceView updatedView = service.save(createdView);
        assertNotNull(updatedView);
        assertEquals(updatedView.getId(), createdView.getId());
        assertEquals(updatedView.getJndiName(), createdView.getJndiName());
        assertEquals(updatedView.getName(), createdView.getName());
        assertEquals(updatedView.getDescription(), createdView.getDescription());


        //find view
        foundView = service.findOne(updatedView.getId());
        assertNotNull(foundView);

        assertNotNull(foundView.getId());
        assertEquals(foundView.getId(), updatedView.getId());
        assertEquals(foundView.getJndiName(), updatedView.getJndiName());
        assertEquals(foundView.getName(), updatedView.getName());
        assertEquals(foundView.getDescription(), updatedView.getDescription());

        service.delete(foundView);
        foundView = service.findOne(updatedView.getId());
        assertNull(foundView);
    }
}
