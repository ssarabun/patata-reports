package com.googlecode.patata.reports.service;

import com.googlecode.patata.reports.dto.ReportFolderView;
import com.googlecode.patata.reports.model.ReportFolder;
import com.googlecode.patata.reports.repository.IReportFolderRepository;
import com.googlecode.patata.reports.service.api.IReportFolderService;
import com.googlecode.patata.reports.service.spi.AbstractServiceImpl;
import com.googlecode.patata.reports.toa.IReportFolderToa;
import com.googlecode.patata.reports.toa.IToa;
import java.util.UUID;
import javax.inject.Inject;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ssarabun
 */
public class ReportFolderServiceImpl extends AbstractServiceImpl<ReportFolderView, ReportFolder, String, UUID>
        implements IReportFolderService {

    @Inject
    private IReportFolderRepository repository;
    @Inject
    private IReportFolderToa toa;

    public ReportFolderView getRootReportFolder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected IReportFolderRepository getRepository() {
        return repository;
    }

    @Override
    protected IReportFolderToa getToa() {
        return toa;
    }

}
