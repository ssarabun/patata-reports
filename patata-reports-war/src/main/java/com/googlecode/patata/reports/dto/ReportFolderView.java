package com.googlecode.patata.reports.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class ReportFolderView extends AbstractDto<UUID> {

    private String name;
    private UUID parentId;
    private Set<ReportFolderView> children = new HashSet<ReportFolderView>();
    private Set<BaseReportView> reports = new HashSet<BaseReportView>();

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

    public Set<ReportFolderView> getChildren() {
        return children;
    }

    public void setChildren(Set<ReportFolderView> children) {
        this.children = children;
    }

    public Set<BaseReportView> getReports() {
        return reports;
    }

    public void setReports(Set<BaseReportView> reports) {
        this.reports = reports;
    }
}
