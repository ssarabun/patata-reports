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
 * @param <E>
 * @param <DTO>
 * @param <EID>
 * @param <DTOID>
 * @date May 23, 2014
 */
public interface IToa<E extends Identifiable<EID>, DTO extends AbstractDto, EID extends Serializable, DTOID extends Serializable>
        extends IIdentifierConvertor<EID, DTOID> {

    DTO create(E entity);

    boolean merge(E entity, DTO dto);

    String resolveDtoField(String dtoFieldName);

    E createEntityInstance(DTO dto);

    Class<E> getEntityCLass();

    DTO createViewInstance(E entity);

    Class<DTO> getDTOCLass();
}
