package com.googlecode.patata.reports.dto;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 8, 2014
 */
public class ExtendedReportDto extends ReportDto {

    private ReportTemplateDto currentTemplate;

    public ReportTemplateDto getCurrentTemplate() {
        return currentTemplate;
    }

    public void setCurrentTemplate(ReportTemplateDto currentTemplate) {
        this.currentTemplate = currentTemplate;
    }
}
