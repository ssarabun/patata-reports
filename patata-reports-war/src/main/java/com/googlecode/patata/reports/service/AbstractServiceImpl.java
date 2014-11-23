package com.googlecode.report.service.service;

import com.googlecode.report.service.model.spi.Identifiable;
import com.googlecode.report.service.repository.spi.IJpaRepositoryFactory;
import com.googlecode.report.service.toa.IToa;
import com.googlecode.report.service.view.AbstractView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date May 23, 2014
 */
public abstract class AbstractServiceImpl<V extends AbstractView<VID>, E extends Identifiable<EID>, EID extends Serializable, VID extends Serializable>
        implements BaseService<V, VID> {

    private static final Logger logger = LoggerFactory.getLogger(AbstractServiceImpl.class);
    @PersistenceContext
    protected EntityManager em;
    @Inject
    private IJpaRepositoryFactory repositoryFactory;

    @Override
    public List<V> findAll() {
        List<E> entityList = getRepository().findAll();
        List<V> resultList = convert(entityList);
        return resultList;
    }

    @Override
    public List<V> findAll(int page, int size, IOrder... order) {

        PageRequest pageRequest = null;
        if (order != null) {
            List<Sort.Order> orders = new ArrayList<>();
            for (IOrder iOrder : order) {
                orders.add(new Sort.Order(
                        iOrder.isAsc() ? Sort.Direction.ASC : Sort.Direction.DESC,
                        iOrder.getFieldName()));
            }
            pageRequest = new PageRequest(page, size, new Sort(orders));
        } else {
            pageRequest = new PageRequest(page, size);
        }

        Page<E> result = getRepository().findAll(pageRequest);
        return convert(result.getContent());
    }

    @Override
    public long count() {
        long count = getRepository().count();
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
        Map<Object, Object> params = new HashMap<>();
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
    public void delete(V DTO) {
        delete(DTO.getId());
    }

    private List<V> convert(Collection<E> entitis) {
        IToa<E, V, EID, VID> toa = getToa();
        List<V> resultList = new ArrayList<>();
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

    protected JpaRepository<E, EID> getRepository() {
        return repositoryFactory.getRepository(getRepositoryInterface(), em);
    }

    protected abstract Class<? extends JpaRepository<E, EID>> getRepositoryInterface();

    protected abstract IToa<E, V, EID, VID> getToa();
}
