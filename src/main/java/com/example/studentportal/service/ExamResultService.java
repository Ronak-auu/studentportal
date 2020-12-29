package com.example.studentportal.service;

import com.example.studentportal.dao.ExamResultDao;
import com.example.studentportal.model.ExamResult;
import com.example.studentportal.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ExamResultService {

    @Autowired
    private ExamResultDao examResultDao;

    public String insertResult(ExamResult examResult) {
        if(examResultDao.checkResultExist(examResult.getStudentId(),examResult.getSubjectId(),examResult.getExamType())!=null){
            return "exists";
        }
        else {
            if(examResultDao.checkStudentExist(examResult.getStudentId())!=null
                    && examResultDao.checkSubjectExist(examResult.getSubjectId())!=null){
                examResultDao.save(examResult);
                return "added";
            }
            else {
                return "Student or Subject not exists";
            }
        }
    }

    public List<ExamResult> getResultByIdAndType(String id, String type){
        return examResultDao.getResultByIdAndType(id,type);
    }

    public int updateResultByIdAndType(ExamResult examResult){
        return examResultDao.updateResultByIdAndType(examResult.getStudentId(),examResult.getSubjectId(),
                examResult.getExamType(),examResult.getExamDate(),examResult.getExamInternalMark(),
                examResult.getExamExternalMark(),examResult.getAttendance());
    }

    public int deleteResultById(String id){
        return examResultDao.deleteResultById(id);
    }
}
