package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.toa.spi.IToa;
import com.googlecode.patata.reports.model.Report;
import com.googlecode.patata.reports.dto.ExtendedReportDto;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 8, 2014
 */
public interface IExtendedReportToa extends IToa<Report, ExtendedReportDto, String, UUID> {
}
