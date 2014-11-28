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
 * @date Aug 6, 2014
 */
@Entity
@Table(name = "rs_report_datasource")
public class ReportDataSource extends UUIDAbstractEntity {

    private String id;
    private String parameterName;
    private DataSource dataSource;
    private ReportTemplate reportTemplate;

    public ReportDataSource() {
    }

    public ReportDataSource(String id) {
        this.id = id;
    }

    @Id
    @Column(name = "report_datasource_id", nullable = false, unique = true)
    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "parameter_name", nullable = false)
    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    @ManyToOne
    @JoinColumn(name = "datasource_id", nullable = false)
    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @ManyToOne
    @JoinColumn(name = "reporttemplate_id", nullable = false)
    public ReportTemplate getReportTemplate() {
        return reportTemplate;
    }

    public void setReportTemplate(ReportTemplate reportTemplate) {
        this.reportTemplate = reportTemplate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 26 * hash + Objects.hashCode(this.getId());
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

        if (!(obj instanceof ReportDataSource)) {
            return false;
        }

        final ReportDataSource other = (ReportDataSource) obj;
        if (this.getId() == null || !Objects.equals(this.getId(), other.getId())) {
            return false;
        }

        return true;
    }
}
