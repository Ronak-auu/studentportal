package com.example.studentportal.api;

import com.example.studentportal.model.ExamResult;
import com.example.studentportal.model.StudentReport;
import com.example.studentportal.model.Teacher;
import com.example.studentportal.service.StudentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("studentreport")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StudentReportController {

    @Autowired
    private StudentReportService studentReportService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public String addStudentReport(@Valid @NonNull @RequestBody StudentReport s){
        return studentReportService.insertStudentReport(s);
    }

    @GetMapping(path = "{eid}/{iid}")
    @PreAuthorize("hasRole('ADMIN')")
    public List<StudentReport> getStudentByGuideId(@PathVariable("eid") String eid, @PathVariable("iid") String iid){
        return studentReportService.getStudentByGuideId(eid,iid);
    }



    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public int updateStudentReport(@Valid @NonNull @RequestBody StudentReport e){
        return studentReportService.updateStudentReport(e);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public int deleteStudentReportById(@PathVariable("id") String id){
        return studentReportService.deleteStudentReportById(id);
    }
}