package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.toa.spi.IToa;
import com.googlecode.patata.reports.model.DataSource;
import com.googlecode.patata.reports.dto.DataSourceDto;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public interface IDataSourceToa extends IToa<DataSource, DataSourceDto, String, UUID> {
}
