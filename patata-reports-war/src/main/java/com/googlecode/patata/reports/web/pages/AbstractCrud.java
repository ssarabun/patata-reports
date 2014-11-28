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
package com.googlecode.patata.reports.web.pages;

import com.googlecode.patata.reports.dto.AbstractDto;
import com.googlecode.patata.reports.service.spi.BaseService;
import java.io.Serializable;

/**
 *
 * @author Sergey Sarabun <sergey.sarabun@gmail.com>
 * @param <DTOID>
 * @param <DTO>
 * @param <S>
 * @date Nov 27, 2014
 */
public abstract class AbstractCrud<DTOID extends Serializable, DTO extends AbstractDto<DTOID>, S extends BaseService<DTO, DTOID>> {

    DTO onNewItem() {
        return createDto();
    }

    DTO onPrepareItem(String id) {
        DTO ds = null;
        if (id != null) {
            ds = getService().findOne(convert(id));
        } else {
            ds = createDto();
        }
        return ds;
    }

    void onDeleteItem(String id) {
        getService().delete(convert(id));
    }

    void onSaveItem(DTO item) {
        getService().save(item);
    }

    protected abstract DTO createDto();

    protected abstract S getService();

    protected abstract DTOID convert(String id);
}
