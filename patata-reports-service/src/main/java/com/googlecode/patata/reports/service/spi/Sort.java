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

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @date Nov 24, 2014
 */
public class Sort implements Iterable<Order>, java.io.Serializable {

    private final List<Order> orders;
    private Direction direction;

    public Sort(Order... orders) {
        this.orders = Arrays.asList(orders);
    }

    public Sort(List<Order> orders) {
        this.orders = orders;
    }

    public Sort(Direction direction, List<Order> orders) {
        this.direction = direction;
        this.orders = orders;
    }

    public Iterator<Order> iterator() {
        if (direction != null) {
            for (Order order : orders) {
                order.setDirection(direction);
            }
        }
        return orders.iterator();
    }
}