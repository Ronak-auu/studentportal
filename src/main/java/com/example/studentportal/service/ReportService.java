package com.example.studentportal.service;

import com.example.studentportal.dao.ReportDao;
import com.example.studentportal.model.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    ReportDao reportDao;

    public int addReport(MultipartFile file,Report r) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Report rt = new Report(r.getrId(),r.getStudentId(),r.getReportNo(),
                file.getBytes(),fileName, file.getContentType(),r.getReportDate(),
                r.getExternalStatus(),r.getInternalStatus());
        reportDao.save(rt);
        return 1;
    }

    public Report findReportById(String id) {
        return reportDao.findById(id).orElse(null);
    }

    public List<Report> findReportByStudentId(String id) {
        return reportDao.findReportByStudentId(id);
    }

    public int deleteReportById(String id) {
        reportDao.deleteById(id);
        return 1;
    }
}
