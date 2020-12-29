package com.example.studentportal.service;

import com.example.studentportal.dao.TeacherDao;
import com.example.studentportal.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    public Teacher saveTeacher(Teacher teacher){
       return teacherDao.save(teacher);
    };

    public List<Teacher> getTeachers(){
        return (List<Teacher>) teacherDao.findAll();
    }
    public Teacher getTeacherById(String id){
        return teacherDao.findById(id).orElse(null);
    }
    /*public Teacher getTeacherByName(String name){
        return teacherDao.findByName(name);
    }*/

    public String deleteTeacher(String id){
        teacherDao.deleteById(id);
        return "Teacher Removed  !" + id ;
    };

    public Teacher updateTeacher(Teacher teacher){
        Teacher existingTeacher = teacherDao.findById(teacher.getTeacherId()).orElse(null);
        existingTeacher.setTeacherEmail(teacher.getTeacherEmail());
        existingTeacher.setTeacherName(teacher.getTeacherName());
        existingTeacher.setTeacherGender(teacher.getTeacherGender());
        existingTeacher.setTeacherDob(teacher.getTeacherDob());
        existingTeacher.setTeacherPhone(teacher.getTeacherPhone());
        existingTeacher.setTeacherAddress(teacher.getTeacherAddress());
        return teacherDao.save(existingTeacher);

    }
}
