package com.example.studentportal.api;

import com.example.studentportal.model.Student;
import com.example.studentportal.model.Subject;
import com.example.studentportal.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/subject")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public void addSubject(@NonNull @Valid @RequestBody Subject subject){
        subjectService.saveSubject(subject);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('TEACHER')")
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Subject getSubjectById(@PathVariable("id") String id){
        return subjectService.getSubjectById(id);
    }

    @PutMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void updateSubjectById(@PathVariable("id") String id,@NonNull @Valid @RequestBody Subject subject){
        subjectService.updateSubject(id,subject);
    }

    @DeleteMapping(path = "{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteSubjectById(@PathVariable("id") String id){
        subjectService.deleteSubject(id);
    }
}
