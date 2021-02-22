package com.example.studentportal.service;

import com.example.studentportal.dao.ReportDao;
import com.example.studentportal.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    public int addReport(Report r) {
        reportDao.save(r);
        return 1;
    }

    public Report findReportById(String id) {
        return reportDao.findById(id).orElse(null);
    }

    public List<Report> findReportByStudentId(String id) {
        return reportDao.findReportByStudentId(id);
    }

    public int updateReportById(String id, Report r) {

        reportDao.findById(id).map(existingReport -> {
            existingReport.setReportNo(r.getReportNo());
            existingReport.setReportDate(r.getReportDate());
            existingReport.setReportLink(r.getReportLink());
            existingReport.setExternalStatus(r.getExternalStatus());
            existingReport.setInternalStatus(r.getInternalStatus());
            reportDao.save(existingReport);
            return 1;
        });
        return 1;
    }

    public int deleteReportById(String id) {
        reportDao.deleteById(id);
        return 1;
    }
}
