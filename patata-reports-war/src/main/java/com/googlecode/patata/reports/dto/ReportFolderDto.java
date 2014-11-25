package com.googlecode.patata.reports.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportFolderDto extends AbstractDto<UUID> {

    private String name;
    private UUID parentId;
    private Set<ReportFolderDto> children = new HashSet<ReportFolderDto>();
    private Set<BaseReportDto> reports = new HashSet<BaseReportDto>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getParentId() {
        return parentId;
    }

    public void setParentId(UUID parentId) {
        this.parentId = parentId;
    }

    public Set<ReportFolderDto> getChildren() {
        return children;
    }

    public void setChildren(Set<ReportFolderDto> children) {
        this.children = children;
    }

    public Set<BaseReportDto> getReports() {
        return reports;
    }

    public void setReports(Set<BaseReportDto> reports) {
        this.reports = reports;
    }
}
