package com.googlecode.patata.reports.toa;

import com.googlecode.patata.reports.model.ReportTemplate;
import com.googlecode.patata.reports.dto.ReportTemplateView;
import java.util.UUID;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public interface IReportTemplateToa extends IToa<ReportTemplate, ReportTemplateView, String, UUID> {
}
