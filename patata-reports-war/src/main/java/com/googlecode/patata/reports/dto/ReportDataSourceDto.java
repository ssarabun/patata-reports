package com.googlecode.patata.reports.dto;

import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 6, 2014
 */
public class ReportDataSourceDto extends AbstractDto<UUID> {

    private String parameterName;
    private UUID datasourceId;

    public ReportDataSourceDto() {
    }

    public ReportDataSourceDto(String parameterName, UUID datasourceId) {
        this.parameterName = parameterName;
        this.datasourceId = datasourceId;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public UUID getDatasourceId() {
        return datasourceId;
    }

    public void setDatasourceId(UUID datasourceId) {
        this.datasourceId = datasourceId;
    }
}
