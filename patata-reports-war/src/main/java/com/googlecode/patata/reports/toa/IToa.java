/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.spi.Identifiable;
import com.googlecode.patata.reports.toa.convertor.IIdentifierConvertor;
import com.googlecode.patata.reports.dto.AbstractDto;
import java.io.Serializable;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date May 23, 2014
 */
public interface IToa<E extends Identifiable<EID>, V extends AbstractDto, EID extends Serializable, VID extends Serializable>
        extends IIdentifierConvertor<EID, VID> {

    V create(E entity);

    boolean merge(E entity, V view);

    E createEntityInstance(V view);

    V createViewInstance(E entity);
}
