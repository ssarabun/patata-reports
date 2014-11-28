/*
 *  Copyright (C) 2014 sergey.sarabun@gmail.com.
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
package com.googlecode.patata.reports.model;

import com.googlecode.patata.reports.model.spi.IColumnDefinition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
@Entity
@Table(name = "rs_report_template")
public class ReportTemplate extends UUIDAbstractEntity {

    private String id;
    private Date created;
    private ReportTemplate prevVersion;
    private String name;
    private String content;
    private DataSource defaultDatasource;
    private List<ReportDataSource> reportDataSources = new ArrayList<ReportDataSource>();
    private Report report;

    public ReportTemplate() {
    }

    public ReportTemplate(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "report_template_id", nullable = false, unique = true)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "created", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @OneToOne
    @JoinColumn(name = "previous_version_temnplate_id")
    public ReportTemplate getPrevVersion() {
        return prevVersion;
    }

    public void setPrevVersion(ReportTemplate prevVersion) {
        this.prevVersion = prevVersion;
    }

    @Column(name = "name", nullable = false, columnDefinition = IColumnDefinition.TEXT_COLUMN_DEFINITION)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "content", nullable = false, columnDefinition = IColumnDefinition.TEXT_COLUMN_DEFINITION)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "default_datasource_id", nullable = false)
    public DataSource getDefaultDatasource() {
        return defaultDatasource;
    }

    public void setDefaultDatasource(DataSource defaultDatasource) {
        this.defaultDatasource = defaultDatasource;
    }

    @OneToMany(mappedBy = "reportTemplate", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    public List<ReportDataSource> getReportDataSources() {
        return reportDataSources;
    }

    public void setReportDataSources(List<ReportDataSource> reportDataSources) {
        this.reportDataSources = reportDataSources;
    }

    @ManyToOne
    @JoinColumn(name = "report_id")
    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @PrePersist
    @Override
    protected void prePersist() {
        super.prePersist();
        setCreated(new Date());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 1 * hash + Objects.hashCode(this.getId());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (!(obj instanceof ReportTemplate)) {
            return false;
        }

        final ReportTemplate other = (ReportTemplate) obj;
        if (this.getId() == null || !Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "ReportTemplate{" + "id=" + id + ", created=" + created + ", prevVersion=" + prevVersion + ", name=" + name + ", content=" + content + ", defaultDatasource=" + defaultDatasource + '}';
    }
}
