package com.example.studentportal.api;

import com.example.studentportal.model.Student;
import com.example.studentportal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("admin/student")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public void addStudent(@NonNull @Valid @RequestBody Student s){
        studentService.insertStudent(s);
    }

    @GetMapping
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "{id}")
    public Optional<Student> getStudentById(@PathVariable("id") String id){
        return studentService.findStudentById(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudentById(@PathVariable("id") String id,@NonNull @Valid @RequestBody Student s){
        studentService.updateStudentById(id,s);
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudentById(@PathVariable("id") String id){
        studentService.deleteStudentById(id);
    }
}
