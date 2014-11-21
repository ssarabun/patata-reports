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
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
@Entity
@Table(name = "rs_report_folder")
public class ReportFolder extends UUIDAbstractEntity {

    private String id;
    private String name;
    private ReportFolder parent;
    private List<ReportFolder> children;
    private Set<Report> reports = new HashSet<Report>();

    public ReportFolder() {
    }

    public ReportFolder(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "report_folder_id", nullable = false, unique = true)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "folder_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public ReportFolder getParent() {
        return parent;
    }

    public void setParent(ReportFolder parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent")
    public List<ReportFolder> getChildren() {
        return children;
    }

    public void setChildren(List<ReportFolder> children) {
        this.children = children;
    }

    @OneToMany(mappedBy = "folder")
    public Set<Report> getReports() {
        return reports;
    }

    public void setReports(Set<Report> reports) {
        this.reports = reports;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 99 * hash + Objects.hashCode(this.getId());
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

        if (!(obj instanceof ReportFolder)) {
            return false;
        }

        final ReportFolder other = (ReportFolder) obj;
        if (this.getId() == null || !Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }
}
