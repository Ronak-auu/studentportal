package com.example.studentportal.api;

import com.example.studentportal.model.Teacher;
import com.example.studentportal.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin/teacher")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PostMapping
    public Teacher addTeacher(@NonNull @Valid @RequestBody Teacher teacher){
        return teacherService.saveTeacher(teacher);
    }

    @GetMapping
    public List<Teacher> findAllTeachers(){
        return teacherService.getTeachers();
    }
    @GetMapping(path = "{id}")
    public Teacher findTeacherByID(@PathVariable("id") String id){
        return teacherService.getTeacherById(id);
    }

    @PutMapping(path = "{id}")
    public Teacher updateTeacher(@PathVariable("id") String id,@NonNull @Valid @RequestBody Teacher teacher){
        return teacherService.updateTeacher(id,teacher);
    }

    @DeleteMapping(path = "{id}")
    public String deleteTeacher(@PathVariable("id") String id){
        return teacherService.deleteTeacher(id);
    }
}
