package com.example.studentportal.service;

import com.example.studentportal.dao.SubjectDao;
import com.example.studentportal.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    public Subject saveSubject(Subject subject){
        return subjectDao.save(subject);
    };

    public List<Subject> getAllSubjects(){
        return (List<Subject>) subjectDao.findAll();
    }
    public Subject getSubjectById(String id){
        return subjectDao.findById(id).orElse(null);
    }


    public String deleteSubject(String id){
        subjectDao.deleteById(id);
        return "Subject Removed ! " + id ;
    };

    public Subject updateSubject(String id,Subject subject){
        Subject existingSubject = subjectDao.findById(id).orElse(null);
        existingSubject.setSubjectName(subject.getSubjectName());
        existingSubject.setSubjectCredit(subject.getSubjectCredit());
        existingSubject.setSubjectBranch(subject.getSubjectBranch());
        existingSubject.setSubjectSemester(subject.getSubjectSemester());
        return subjectDao.save(existingSubject);

    }
}
