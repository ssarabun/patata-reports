/*
 *  Copyright (C) 2014 Sergey Sarabun <sergey.sarabun@gmail.com>.
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
package com.googlecode.patata.reports.web.utils;

import com.googlecode.patata.reports.dto.DataSourceDto;
import com.googlecode.patata.reports.service.api.IDataSourceService;
import java.util.UUID;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @date Nov 25, 2014
 */
public class DataSourceGridDataSource extends AbstractGridDataSource<DataSourceDto, UUID> {

    public DataSourceGridDataSource(IDataSourceService service) {
        super(service);
    }

    public Class getRowType() {
        return DataSourceDto.class;
    }

}
