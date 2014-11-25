package com.googlecode.patata.reports.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class ReportTemplateDto extends AbstractDto<UUID> {

    private Date created;
    private UUID prevVersionId;
    private String name;
    private String content;
    private UUID defaultDatasourceId;
    private List<ReportDataSourceDto> reportDatasources = new ArrayList<ReportDataSourceDto>();

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public UUID getPrevVersionId() {
        return prevVersionId;
    }

    public void setPrevVersionId(UUID prevVersionId) {
        this.prevVersionId = prevVersionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UUID getDefaultDatasourceId() {
        return defaultDatasourceId;
    }

    public void setDefaultDatasourceId(UUID defaultDatasourceId) {
        this.defaultDatasourceId = defaultDatasourceId;
    }

    public List<ReportDataSourceDto> getReportDatasources() {
        return reportDatasources;
    }

    public void setReportDatasources(List<ReportDataSourceDto> reportDatasources) {
        this.reportDatasources = reportDatasources;
    }
}
