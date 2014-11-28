package com.googlecode.patata.reports.utils.mapper.impl;

import com.googlecode.patata.reports.utils.mapper.spi.AbstractCustomConverter;
import com.googlecode.patata.reports.model.ReportFolder;
import com.googlecode.patata.reports.repository.IReportFolderRepository;
import com.googlecode.patata.reports.toa.convertor.IStringToUUIDIdentifierConvertor;
import com.googlecode.patata.reports.dto.ReportFolderDto;
import com.googlecode.patata.reports.utils.mapper.IReportFolderToUUIDConverter;
import java.util.UUID;
import javax.inject.Inject;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 5, 2014
 */
public class ReportFolderToUUIDConverter extends AbstractCustomConverter<ReportFolder, ReportFolderDto, String, UUID>
        implements IReportFolderToUUIDConverter {

    @Inject
    private IReportFolderRepository repository;
    @Inject
    private IStringToUUIDIdentifierConvertor identifierConvertor;

    public ReportFolderToUUIDConverter() {
        super(UUID.class, ReportFolder.class);
    }

    @Override
    public IReportFolderRepository getRepository() {
        return repository;
    }

    @Override
    protected IStringToUUIDIdentifierConvertor getIdentifierConvertor() {
        return identifierConvertor;
    }

    @Override
    public String getConverterName() {
        return "ReportFolderToUUIDConverter";
    }
}
