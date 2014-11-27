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
import com.googlecode.patata.reports.service.spi.Direction;
import com.googlecode.patata.reports.service.spi.Order;
import com.googlecode.patata.reports.service.spi.Page;
import com.googlecode.patata.reports.service.spi.Pageable;
import com.googlecode.patata.reports.service.spi.Sort;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.grid.ColumnSort;
import org.apache.tapestry5.grid.GridDataSource;
import org.apache.tapestry5.grid.SortConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @param <V>
 * @param <VID>
 * @date Nov 26, 2014
 */
public abstract class AbstractGridDataSource<V extends AbstractDto, VID extends Serializable>
        implements GridDataSource {

    private static final Logger logger = LoggerFactory.getLogger(AbstractGridDataSource.class);
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

        logger.info("sortConstraints = " + sortConstraints);

        Page<V> page = service.findAll(createPageable(startIndex, endIndex, sortConstraints));
        list = page.getContent();
    }

    private Pageable createPageable(int startIndex, int endIndex, List<SortConstraint> sortConstraints) {
        int pageSize = endIndex - startIndex + 1;
        int pageOffset = startIndex / pageSize;

        if (sortConstraints.isEmpty()) {
            return new Pageable(pageOffset, pageSize);
        } else {
            List<Order> orders = new ArrayList<Order>(sortConstraints.size());
            for (SortConstraint sortConstraint : sortConstraints) {
                logger.info("PropertyModel = " + sortConstraint.getPropertyModel());
                orders.add(new Order(convert(sortConstraint.getColumnSort()),
                        sortConstraint.getPropertyModel().getPropertyName()));
            }
            
            return new Pageable(pageOffset, pageSize, new Sort(orders));
        }

    }

    private Direction convert(ColumnSort columnSort) {
        if (columnSort == ColumnSort.ASCENDING) {
            return Direction.ASCENDING;
        } else if (columnSort == ColumnSort.DESCENDING) {
            return Direction.DESCENDING;
        } else if (columnSort == ColumnSort.UNSORTED) {
            return Direction.UNSORTED;
        }

        return Direction.UNSORTED;
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
