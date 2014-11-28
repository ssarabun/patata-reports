package com.googlecode.patata.reports.toa.spi;

import com.googlecode.patata.reports.dto.spi.AbstractDto;
import com.googlecode.patata.reports.model.spi.Identifiable;
import com.googlecode.patata.reports.toa.convertor.IIdentifierConvertor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.dozer.Mapper;
import org.dozer.metadata.ClassMappingMetadata;
import org.dozer.metadata.FieldMappingMetadata;
import org.dozer.metadata.MappingMetadata;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @param <E>
 * @param <DTO>
 * @param <EID>
 * @param <DTOID>
 * @date May 23, 2014
 */
public abstract class AbsrtactToaImpl<E extends Identifiable<EID>, DTO extends AbstractDto, EID extends Serializable, DTOID extends Serializable>
        implements IToa<E, DTO, EID, DTOID> {

    @Inject
    private Mapper dozzer;
    @Inject
    private MappingMetadata metadata;

    @Override
    public DTO create(E entity) {
        if (entity == null) {
            return null;
        }

        DTO view = createViewInstance(entity);
        dozerMap(entity, view);
        return view;
    }

    @Override
    public boolean merge(E entity, DTO view) {
        dozerMap(view, entity);
        return true;
    }

    @Override
    public DTOID convertEntityId(EID id) {
        return getIdentifierConvertor().convertEntityId(id);
    }

    @Override
    public EID convertViewId(DTOID id) {
        return getIdentifierConvertor().convertViewId(id);
    }

    public String resolveDtoField(String dtoFieldName) {
        ClassMappingMetadata classMetadata = metadata.getClassMapping(getEntityCLass(), getDTOCLass());
        FieldMappingMetadata fieldMetadata = classMetadata.getFieldMappingByDestination(dtoFieldName);
        return fieldMetadata.getSourceName();
    }

    protected <V extends AbstractDto<VID>, E extends Identifiable<EID>, EID extends Serializable, VID extends Serializable> void mergeCollection(
            Collection<V> views,
            Collection<E> entities,
            MergeCollectionCallBack<E, V, EID, VID> callback) {

        Map<Object, E> map = new HashMap<Object, E>();
        for (E entity : entities) {
            map.put(entity.getId(), entity);
        }

        List<E> list = new ArrayList<E>();

        for (V view : views) {
            E entity = null;
            if (view.getId() == null) {
                entity = callback.createEntity(view);
            } else {
                EID eid = callback.convertId(view.getId());
                entity = map.get(eid);
            }

            dozerMap(view, entity);

            if (view.getId() == null) {
                callback.beforeSave(entity, view);
                entities.add(entity);
            }
            list.add(entity);
        }

        Iterator<E> it = entities.iterator();
        while (it.hasNext()) {
            E entity = it.next();
            if (!list.contains(entity)) {
                it.remove();
            }
        }
    }

    protected interface MergeCollectionCallBack<E extends Identifiable, V extends AbstractDto, EID extends Serializable, VID extends Serializable> {

        E createEntity(V view);

        EID convertId(VID id);

        void beforeSave(E entity, V view);
    }

    private void dozerMap(Object obj1, Object obj2) {
        dozzer.map(obj1, obj2);
    }

    protected abstract IIdentifierConvertor<EID, DTOID> getIdentifierConvertor();
}
