package com.googlecode.patata.reports.service.spi;

import com.googlecode.patata.reports.dto.AbstractDto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @param <V>
 * @param <VID>
 * @date May 26, 2014
 */
public interface BaseService<V extends AbstractDto, VID extends Serializable> {

    V findOne(VID id);

    List<V> findAll();

    List<V> findAll(int start, int end);

    Page<V> findAll(Pageable pageable);

    long count();

    /**
     * Used for "lists" functionality to count number of records by specific
     * search criteria.
     */
    //TODO QueryField
//    long count(List<QueryField> queryFields);
    /**
     * Used for "lists" functionality.
     */
    //TODO QueryField
//    List<DTO> findAll(List<QueryField> queryFields);
    /**
     * Used for "lists" functionality with pagination support.
     *
     * @param view
     * @return saved view
     */
    //TODO QueryField
//    List<DTO> findAll(int page, int size, List<QueryField> queryFields);
    V save(V view);

    /**
     * Deletes the DTO with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@code id} is
     * {@literal null}
     */
    void delete(VID id);

    /**
     * Deletes a given DTO.
     *
     * @param DTO
     * @throws IllegalArgumentException in case the given DTO is (@literal
     * null}.
     */
    void delete(V DTO);
}
