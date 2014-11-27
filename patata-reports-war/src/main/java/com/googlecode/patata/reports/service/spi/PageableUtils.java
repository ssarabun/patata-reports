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
package com.googlecode.patata.reports.service.spi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @date Nov 24, 2014
 */
public abstract class PageableUtils {

    public static <V extends Serializable> Page convert(List<V> result, Pageable pageable) {
        return new Page<V>(result, pageable);
    }

    public static org.springframework.data.domain.Pageable convert(Pageable pageable) {
        PageRequest pageRequest = null;
        if (pageable.getSort() != null) {
            List<org.springframework.data.domain.Sort.Order> orders = new ArrayList<org.springframework.data.domain.Sort.Order>();
            Iterator<Order> it = pageable.getSort().iterator();
            while (it.hasNext()) {
                Order next = it.next();
                orders.add(convert(next));
            }
            pageRequest = new PageRequest(pageable.getPage(), pageable.getPageSize(), new org.springframework.data.domain.Sort(orders));
        } else {
            pageRequest = new PageRequest(pageable.getPage(), pageable.getPageSize());
        }

        return pageRequest;
    }

    public static org.springframework.data.domain.Sort.Order convert(Order order) {
        org.springframework.data.domain.Sort.Order newOrder
                = new org.springframework.data.domain.Sort.Order(
                        order.getDirection() == Direction.ASCENDING
                                ? org.springframework.data.domain.Sort.Direction.ASC
                                : org.springframework.data.domain.Sort.Direction.DESC,
                        order.getProperty());

        if (order.isIgnoreCase()) {
            newOrder = newOrder.ignoreCase();
        }

        return newOrder;
    }
}
