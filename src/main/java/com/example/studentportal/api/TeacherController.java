package com.example.studentportal.api;

import com.example.studentportal.model.Teacher;
import com.example.studentportal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping("admin/addTeacher")
    public Teacher addTeacher(@RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping("admin/teachers")
    public List<Teacher> findAllTeachers(){
        return teacherService.getTeachers();
    }
    @GetMapping("admin/teacher/{id}")
    public Teacher findTeacherByID(@PathVariable("id") String id){
        return teacherService.getTeacherById(id);
    }

    @PutMapping("admin/updateTeacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher){
        return teacherService.updateTeacher(teacher);
    }

    @DeleteMapping("admin/deleteTeacher/{id}")
    public String deleteTeacher(@PathVariable("id") String id){
        return teacherService.deleteTeacher(id);
    }
}
