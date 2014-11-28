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
import java.util.List;

/**
 *
 * @param <T>
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @date Nov 24, 2014
 */
public class Page<T extends Serializable> implements Serializable {

    private final List<T> content;
    private final Pageable pageable;

    public Page(List<T> content, Pageable pageable) {
        this.content = content;
        this.pageable = pageable;
    }

    public List<T> getContent() {
        return content;
    }

    public Pageable nextPageable() {
        return pageable.next();
    }

    public Pageable previousPageable() {
        return pageable.previous();
    }
}
