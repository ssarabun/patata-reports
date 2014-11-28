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
package com.googlecode.patata.reports.model.spi;

import java.io.Serializable;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date May 23, 2014
 */
@MappedSuperclass
public abstract class AbstractEntity<T extends Serializable>
        implements Identifiable<T> {

    private long version;

    @Version
    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "id=" + getId() + '}';
    }
}
