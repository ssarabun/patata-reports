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

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
@Entity
@Table(name = "rs_report")
public class Report extends UUIDAbstractEntity {

    private String id;
    private String name;
    private ReportFolder folder;
    private Set<ReportTemplate> reportTemplates = new HashSet<ReportTemplate>();
    private ReportTemplate currentTemplate;

    public Report() {
    }

    public Report(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "report_id", nullable = false, unique = true)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "report_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "report_folder_id", nullable = false)
    public ReportFolder getFolder() {
        return folder;
    }

    public void setFolder(ReportFolder folder) {
        this.folder = folder;
    }

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "current_template_id", nullable = false)
    public ReportTemplate getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(ReportTemplate currentTemplate) {
        this.currentTemplate = currentTemplate;
    }

    @OneToMany(mappedBy = "report", cascade = {CascadeType.REMOVE})
    public Set<ReportTemplate> getReportTemplates() {
        return reportTemplates;
    }

    public void setReportTemplates(Set<ReportTemplate> reportTemplates) {
        this.reportTemplates = reportTemplates;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.getId());
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

        if (!(obj instanceof Report)) {
            return false;
        }

        final Report other = (Report) obj;
        if (this.getId() == null || !Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", name=" + name + ", folder=" + folder + ", reportTemplates=" + reportTemplates + ", currentTemplate=" + currentTemplate + '}';
    }
}
