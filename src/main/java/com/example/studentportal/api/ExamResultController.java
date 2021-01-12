package com.example.studentportal.api;

import com.example.studentportal.model.ExamResult;
import com.example.studentportal.service.ExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/exam")
@CrossOrigin(origins = "*", maxAge = 3600)
public class ExamResultController {

    @Autowired
    private ExamResultService examResultService;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addResult(@Valid @NonNull @RequestBody ExamResult e){
        return examResultService.insertResult(e);
    }

    @GetMapping(path = "{id}/{type}")
    public List<ExamResult> getResultByIdAndType(@PathVariable("id") String id, @PathVariable("type") String type){
        return examResultService.getResultByIdAndType(id,type);
    }

    @GetMapping(path = "{id}")
    public List<ExamResult> getResultByStudentId(@PathVariable("id") String id){
        return examResultService.getResultByStudentId(id);
    }
    @GetMapping(path = "result/{id}")
    public ExamResult getResultByResultId(@PathVariable("id") String id){
        return examResultService.getResultByResultId(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public int updateResultByIdAndType(@Valid @NonNull @RequestBody ExamResult e){
        return examResultService.updateResultByIdAndType(e);
    }

    //Student Id
    @DeleteMapping(path = "{id}")
    public int deleteResultById(@PathVariable("id") String id){
        return examResultService.deleteResultById(id);
    }
}
