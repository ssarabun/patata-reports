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
package com.googlecode.patata.reports.toa.convertor;

import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public class StringToUUIDIdentifierConvertorImpl implements IStringToUUIDIdentifierConvertor {

    @Override
    public UUID convertEntityId(String id) {
        if (id == null) {
            return null;
        }

        return UUID.fromString(id);
    }

    @Override
    public String convertViewId(UUID id) {
        if (id == null) {
            return null;
        }

        return id.toString();
    }
}
