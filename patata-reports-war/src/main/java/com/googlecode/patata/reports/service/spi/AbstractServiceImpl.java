package com.googlecode.patata.reports.service.spi;

import com.googlecode.patata.reports.dto.AbstractDto;
import com.googlecode.patata.reports.model.spi.Identifiable;
import com.googlecode.patata.reports.toa.IToa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @param <V>
 * @param <E>
 * @param <EID>
 * @param <VID>
 * @date May 23, 2014
 */
@Transactional
public abstract class AbstractServiceImpl<V extends AbstractDto<VID>, E extends Identifiable<EID>, EID extends Serializable, VID extends Serializable>
        implements BaseService<V, VID> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractServiceImpl.class);

    @Override
    public List<V> findAll() {
        List<E> entityList = getRepository().findAll();
        List<V> resultList = convert(entityList);
        return resultList;
    }

    @Override
    public List<V> findAll(Pageable pageable) {
        Page<E> result = getRepository().findAll(PageableUtils.convert(pageable));
        return convert(result.getContent());
    }

    @Override
    public long count() {
        JpaRepository<E, EID> repository = getRepository();
        System.out.println("repository = " + repository);
        Long count = repository.count();
        System.out.println("count = " + count);
        return count;
    }

    @Override
    public V findOne(VID id) {
        IToa<E, V, EID, VID> toa = getToa();
        EID eId = toa.convertViewId(id);
        E entity = getRepository().findOne(eId);
        if (entity == null) {
            return null;
        }

        return getToa().create(entity);
    }

    @Override
    public V save(V view) {
        IToa<E, V, EID, VID> toa = getToa();
        JpaRepository<E, EID> repository = getRepository();

        E entity = null;
        if (view.getId() == null) {
            entity = toa.createEntityInstance(view);
        } else {
            VID id = view.getId();
            EID eId = toa.convertViewId(id);
            entity = repository.findOne(eId);
        }
        Map<Object, Object> params = new HashMap<Object, Object>();
        beforeMerge(view, entity, params);
        toa.merge(entity, view);
        beforeSave(view, entity, params);
        entity = repository.saveAndFlush(entity);
        view = toa.create(entity);

        return view;
    }

    @Override
    public void delete(VID id) {
        JpaRepository<E, EID> repository = getRepository();
        IToa<E, V, EID, VID> toa = getToa();
        EID eId = toa.convertViewId(id);
        E entity = repository.getOne(eId);
        beforeDelete(entity);
        repository.delete(entity);
    }

    @Override
    public void delete(V dto) {
        delete(dto.getId());
    }

    private List<V> convert(Collection<E> entitis) {
        IToa<E, V, EID, VID> toa = getToa();
        List<V> resultList = new ArrayList<V>();
        for (E entity : entitis) {
            resultList.add(toa.create(entity));
        }
        return resultList;
    }

    protected void beforeMerge(V view, E entity, Map<Object, Object> params) {
    }

    protected void beforeSave(V view, E entity, Map<Object, Object> params) {
    }

    protected void beforeDelete(E entity) {
    }

    protected abstract JpaRepository<E, EID> getRepository();

    protected abstract IToa<E, V, EID, VID> getToa();
}
