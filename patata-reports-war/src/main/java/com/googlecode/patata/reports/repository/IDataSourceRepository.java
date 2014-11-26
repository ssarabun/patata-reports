package com.googlecode.patata.reports.repository;

import com.googlecode.patata.reports.model.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
@Repository
public interface IDataSourceRepository extends JpaRepository<DataSource, String> {
}
