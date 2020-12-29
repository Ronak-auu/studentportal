package com.example.studentportal.service;

import com.example.studentportal.model.Student;
import com.example.studentportal.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private StudentDao studentDAO;

    @Autowired
    public StudentService(StudentDao studentDAO){
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public void insertStudent(Student student) {
        studentDAO.save(student);
    }

    public Optional<Student> findStudentById(String id) {
        return studentDAO.findById(id);
    }

    public void updateStudentById(String id,Student student) {
        studentDAO.findById(id).map(s -> {
            s.setStudentName(student.getStudentName());
            s.setStudentAddress(student.getStudentAddress());
            s.setStudentClass(student.getStudentClass());
            s.setStudentDob(student.getStudentDob());
            s.setStudentEmail(student.getStudentEmail());
            s.setStudentGender(student.getStudentGender());
            s.setStudentPhone(student.getStudentPhone());
            s.setStudentNumber(student.getStudentNumber());
            s.setStudentBranch(student.getStudentBranch());
            return studentDAO.save(s);
        }).orElseGet(() ->{
            student.setStudentId(id);
            return studentDAO.save(student);
        });
    }

    public void deleteStudentById(String id){
        studentDAO.deleteById(id);
    }
}
