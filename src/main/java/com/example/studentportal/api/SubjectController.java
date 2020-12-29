package com.example.studentportal.api;

import com.example.studentportal.model.Student;
import com.example.studentportal.model.Subject;
import com.example.studentportal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping
    public void addSubject(@NonNull @Valid @RequestBody Subject subject){
        subjectService.saveSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping(path = "{id}")
    public Subject getSubjectById(@PathVariable("id") String id){
        return subjectService.getSubjectById(id);
    }

    @PutMapping(path = "{id}")
    public void updateSubjectById(@PathVariable("id") String id,@NonNull @Valid @RequestBody Subject subject){
        subjectService.updateSubject(id,subject);
    }

    @DeleteMapping(path = "{id}")
    public void deleteSubjectById(@PathVariable("id") String id){
        subjectService.deleteSubject(id);
    }
}
