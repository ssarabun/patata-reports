package com.googlecode.patata.reports.repository;

import com.googlecode.patata.reports.model.DataSource;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public interface IDataSourceRepository extends JpaRepository<DataSource, String> {
}
