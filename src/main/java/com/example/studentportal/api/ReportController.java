package com.example.studentportal.api;


import com.example.studentportal.model.Report;
import com.example.studentportal.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("report")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ReportController {

    @Autowired
    ReportService reportService;

    @PostMapping
    @PreAuthorize("hasRole('STUDENT')")
    public int addReport(@ModelAttribute(value = "file") MultipartFile file,@ModelAttribute Report r){
        try {
            System.out.println(r);
            return reportService.addReport(file,r);
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public Report getReportById(@PathVariable("id") String id){
        return reportService.findReportById(id);
    }

    @GetMapping(path = "{student}/{id}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public List<Report> getReportByStudentId(@PathVariable("id") String id){
        return reportService.findReportByStudentId(id);
    }


    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('STUDENT')")
    public int deleteReportById(@PathVariable("id") String id){
        return reportService.deleteReportById(id);
    }
}
