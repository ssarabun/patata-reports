package com.googlecode.patata.reports.utils.mapper.spi;

import com.googlecode.patata.reports.model.spi.Identifiable;
import com.googlecode.patata.reports.toa.convertor.IIdentifierConvertor;
import com.googlecode.patata.reports.dto.AbstractDto;
import java.io.Serializable;
import org.dozer.DozerConverter;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public abstract class AbstractCustomConverter<E extends Identifiable<EID>, V extends AbstractDto, EID extends Serializable, VID extends Serializable> extends DozerConverter<VID, E> {

    public AbstractCustomConverter(Class<VID> viewIdType, Class<E> entityType) {
        super(viewIdType, entityType);
    }

    @Override
    public E convertTo(VID vid, E entity) {
        if (vid == null) {
            return null;
        }

        EID id = getIdentifierConvertor().convertViewId(vid);
        return getRepository().getOne(id);
    }

    @Override
    public VID convertFrom(E entity, VID vid) {
        if (entity == null) {
            return null;
        }

        EID eid = entity.getId();
        vid = getIdentifierConvertor().convertEntityId(eid);

        return vid;
    }

    protected abstract JpaRepository<E, EID> getRepository();

    protected abstract IIdentifierConvertor<EID, VID> getIdentifierConvertor();
}
