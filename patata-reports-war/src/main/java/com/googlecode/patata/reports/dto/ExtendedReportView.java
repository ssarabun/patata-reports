package com.googlecode.patata.reports.dto;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 8, 2014
 */
public class ExtendedReportView extends ReportView {

    private ReportTemplateView currentTemplate;

    public ReportTemplateView getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(ReportTemplateView currentTemplate) {
        this.currentTemplate = currentTemplate;
    }
}
