/*
 *  Copyright (C) 2013 sergey.sarabun@gmail.com.
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
package com.googlecode.patata.reports.dto;

import java.io.Serializable;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date May 23, 2014
 */
public class AbstractDto<T extends Serializable> implements java.io.Serializable {

    protected T id;
    protected long version;

    public AbstractDto() {
    }

    public AbstractDto(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }

    public long getVersion() {
        return version;
    }

    public void setId(T id) {
        this.id = id;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + id + ", version=" + version + '}';
    }
}
