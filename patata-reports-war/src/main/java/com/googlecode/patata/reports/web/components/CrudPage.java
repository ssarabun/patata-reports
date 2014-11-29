/*
 *  Copyright (C) 2014 Sergey Sarabun <sergey.sarabun@gmail.com>.
 * 
 *  This library is free software: you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public 
 *  License as published by the Free Software Foundation, either 
 *  version 3 of the License, or (at your option) any later version.
 * 
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 * 
 *  You should have received a copy of the GNU General Public License
 *  along with this library.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.googlecode.patata.reports.web.components;

import com.googlecode.patata.reports.dto.spi.AbstractDto;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.ComponentEventCallback;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.beaneditor.BeanModel;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.internal.beaneditor.BeanModelUtils;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.BeanModelSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @date Nov 27, 2014
 */
public class CrudPage {

    private static final Logger logger = LoggerFactory.getLogger(CrudPage.class);
    @Inject
    private Block viewBlock, editBlock;
    @Inject
    private BeanModelSource beanModelSource;
    @Inject
    private ComponentResources resources;
    @Component(id = "editForm")
    private BeanEditForm form;
    @Parameter(required = true, allowNull = false)
    @Property
    private GridDataSource source;
    @Parameter(required = true)
    @Property
    private int rowsPerPage;
    @Parameter(required = true, allowNull = false)
    @Property
    private String createLinkLabel;
    @Parameter
    @Property
    private String exclude;
    @Property
    @Persist
    private BeanModel model;
    @Property
    @Persist
    private AbstractDto item;
    @Persist
    private String id;
    @Persist
    private boolean editMode;
    private boolean isCanceled;

    String onPassivate() {
        return id;
    }

    void onActivate(String id) {
        this.id = id;
    }

    void onActionFromNew() {

        editMode = true;
        id = null;

        model = beanModelSource.createEditModel(source.getRowType(), resources.getContainerMessages());
        BeanModelUtils.modify(model, null, null, exclude, null);
    }

    void onActionFromDelete(String id) {
        String componentId = resources.getId();
        String event = componentId == null ? "deleteItem" : "deleteItem" + componentId;
        resources.triggerEvent(event, new Object[]{id}, null);
    }

    void onActionFromEdit(String id) {
        logger.info("void onActionFromEdit(" + id + ")");
        this.id = id;
        editMode = true;

        model = beanModelSource.createEditModel(source.getRowType(), resources.getContainerMessages());
        BeanModelUtils.modify(model, null, null, exclude, null);
    }

    void onPrepare() {
        logger.info("void onPrepare()");
        logger.info("id = " + id);
    }

    void onCanceled() {
        logger.info("void onCanceled()");
        editMode = false;
        isCanceled = true;
    }

    void onSuccess() {
        logger.info("void onSuccess()");
        logger.info("item = " + item);
        editMode = false;
    }

    void onPrepareForRender() {
        logger.info("void onPrepareForRender()");
        logger.info("id = " + id);
        String componentId = resources.getId();
        String event = componentId == null ? "prepareItem" : "prepareItem" + componentId;
        resources.triggerEvent(event, new Object[]{id}, new ComponentEventCallback() {
            public boolean handleResult(Object result) {
                item = (AbstractDto) result;
                return true;
            }
        });
    }

    void onPrepareForSubmit() {
        logger.info("void onPrepareForSubmit()");
        logger.info("id = " + id);
    }

    void onValidateFromEditForm() {
        logger.info("void onValidateFromEditForm()");
        if (isCanceled) {
            return;
        }

        if (form.getHasErrors()) {
            // We get here only if a server-side validator detected an error.
            return;
        }

        try {
            String componentId = resources.getId();
            String event = componentId == null ? "saveItem" : "saveItem" + componentId;
            resources.triggerEvent(event, new Object[]{item}, null);
        } catch (Exception e) {
            // Display the cause. In a real system we would try harder to get a user-friendly message.
            form.recordError(e.getLocalizedMessage());
        }
    }

    public Object getActiveBlock() {
        return editMode ? editBlock : viewBlock;
    }
}
