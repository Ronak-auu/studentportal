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
        if(studentReportDao.checkStudentReportExist(studentReport.getStudentId(),studentReport.getExternalId(),studentReport.getInternalId())!=null){
            return "Exists";
        }
        else {
            if(studentReportDao.checkStudentExist(studentReport.getStudentId())!=null
                    && studentReportDao.checkExternalTeacherExist(studentReport.getExternalId())!=null
                        && studentReportDao.checkInternalTeacherExist(studentReport.getInternalId())!=null){
                studentReportDao.save(studentReport);
                return "Added";
            }
            else {
                return "Student or Guide not exists";
            }
        }
    }

    public List<StudentReport> getStudentByGuideId(String eid, String iid){
        return studentReportDao.getStudentByGuideId(eid,iid);
    }

    public List<Teacher> getInternalGuideById(String eid){
        return studentReportDao.getInternalTeacher(eid);
    }

    public List<Teacher> getExternalGuideById(String iid){
        return studentReportDao.getExternalTeacher(iid);
    }

    public int updateStudentReport(StudentReport studentReport){
        if(studentReportDao.checkStudentReportExist(studentReport.getStudentId(),studentReport.getExternalId(),studentReport.getInternalId())!=null){
            studentReportDao.updateStudentReport(studentReport.getStudentId(),studentReport.getInternalId(),
                    studentReport.getExternalId(),studentReport.getProjectDefinition(),studentReport.getWorkLanguage(),
                    studentReport.getStudentPercentage(),studentReport.getCompanyResources(),studentReport.getJoinDate(),
                    studentReport.getEndDate());
            return 1;
        }
        return 0;

    }

    public int deleteStudentReportById(String id){
        if(studentReportDao.existsByStudentReportId(id)) {
            return studentReportDao.deleteStudentReportById(id);
        }
        return 0;
    }
}
