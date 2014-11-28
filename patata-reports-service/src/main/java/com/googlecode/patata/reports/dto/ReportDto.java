package com.googlecode.patata.reports.dto;

import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportDto extends BaseReportDto {

    private UUID folderId;
    private UUID currentTemplateId;

    public UUID getFolderId() {
        return folderId;
    }

    public void setFolderId(UUID folderId) {
        this.folderId = folderId;
    }

    public UUID getCurrentTemplateId() {
        return currentTemplateId;
    }

    public void setCurrentTemplateId(UUID currentTemplateId) {
        this.currentTemplateId = currentTemplateId;
    }
}
