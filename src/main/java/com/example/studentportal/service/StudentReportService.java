package com.example.studentportal.service;

import com.example.studentportal.dao.StudentReportDao;
import com.example.studentportal.model.StudentReport;
import com.example.studentportal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentReportService {

    @Autowired
    private StudentReportDao studentReportDao;

    public String insertStudentReport(StudentReport studentReport) {

                studentReportDao.save(studentReport);
                return "Added";

    }

    public List<StudentReport> getStudentByGuideId(String eid, String iid){
        return studentReportDao.getStudentByGuideId(eid,iid);
    }

    public List<Teacher> getGuideById(String id){
        return studentReportDao.getTeacher(id);
    }

    public int updateStudentReport(StudentReport studentReport){
            studentReportDao.updateStudentReport(studentReport.getStudentId(),studentReport.getInternalId(),
                    studentReport.getExternalId(),studentReport.getProjectDefinition(),studentReport.getWorkLanguage(),
                    studentReport.getStudentPercentage(),studentReport.getCompanyResources(),studentReport.getJoinDate(),
                    studentReport.getEndDate());
            return 1;


    }

    public int deleteStudentReportById(String id){
            return studentReportDao.deleteStudentReportById(id);
    }
}