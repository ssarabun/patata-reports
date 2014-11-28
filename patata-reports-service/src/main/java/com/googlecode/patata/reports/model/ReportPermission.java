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

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
@Entity
@Table(name = "rs_report_permission")
public class ReportPermission extends UUIDAbstractEntity {

    private String id;
    private Group group;
    private Report report;
    private boolean write;

    public ReportPermission() {
    }

    public ReportPermission(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "report_permission_id", nullable = false, unique = true)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @ManyToOne
    @JoinColumn(name = "report_id", nullable = false)
    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    @Column(name = "is_write")
    public boolean isWrite() {
        return write;
    }

    public void setWrite(boolean write) {
        this.write = write;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 63 * hash + Objects.hashCode(this.getId());
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

        if (!(obj instanceof DataSource)) {
            return false;
        }

        final ReportPermission other = (ReportPermission) obj;
        if (this.getId() == null || !Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }
}
