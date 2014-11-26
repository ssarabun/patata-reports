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
public class Pageable implements java.io.Serializable {

    private final int page;
    private final int pageSize;
    private Sort sort;

    public Pageable(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    public Pageable(int page, int pageSize, Sort sort) {
        this.page = page;
        this.pageSize = pageSize;
        this.sort = sort;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPage() {
        return page;
    }

    public Sort getSort() {
        return sort;
    }

    public Pageable next() {
        return new Pageable(pageSize, (page - 1) * pageSize);
    }

    public Pageable previous() {
        return new Pageable(pageSize, (page <= 1 ? 1 : page - 1) * pageSize);
    }
}
