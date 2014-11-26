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

import com.googlecode.patata.reports.dto.AbstractDto;
import com.googlecode.patata.reports.service.spi.BaseService;
import java.io.Serializable;
import java.util.List;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @param <V>
 * @param <VID>
 * @date Nov 26, 2014
 */
public abstract class AbstractGridDataSource<V extends AbstractDto, VID extends Serializable>
        implements GridDataSource {

    private final BaseService<V, VID> service;
    private List<V> list;
    private int startIndex;

    public AbstractGridDataSource(BaseService<V, VID> service) {
        this.service = service;
    }

    public int getAvailableRows() {
        return (int) service.count();
    }

    public void prepare(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
        this.startIndex = startIndex;
        list = service.findAll(startIndex, endIndex);
    }

    public Object getRowValue(int index) {
        index = index - this.startIndex;
        if (list.isEmpty()) {
            return null;
        }

        if (list.size() <= index) {
            return null;
        }

        return list.get(index);
    }
}
