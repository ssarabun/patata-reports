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

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @date Nov 24, 2014
 */
public class Order implements java.io.Serializable {

    private Direction direction = Direction.ASCENDING;
    private String property;
    private boolean ignoreCase;

    public Order() {
    }

    public Order(String property) {
        this.property = property;
    }

    public Order(Direction direction, String property) {
        this.direction = direction;
        this.property = property;
    }

    public Order(Direction direction, String property, boolean ignoreCase) {
        this.direction = direction;
        this.property = property;
        this.ignoreCase = ignoreCase;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public boolean isIgnoreCase() {
        return ignoreCase;
    }

    public void setIgnoreCase(boolean ignoreCase) {
        this.ignoreCase = ignoreCase;
    }

    public Order newOrder(String property) {
        return new Order(direction, property, ignoreCase);
    }

    @Override
    public String toString() {
        return "Order{" + "direction=" + direction + ", property=" + property + '}';
    }
}
