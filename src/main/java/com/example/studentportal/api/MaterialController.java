package com.example.studentportal.api;

import com.example.studentportal.model.Material;
import com.example.studentportal.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("material")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MaterialController {

    @Autowired
    private MaterialService materialService;

    @PostMapping
    public String addMaterial(@Valid @NonNull @RequestBody Material material) {
        return materialService.addMaterial(material);
    }

    @GetMapping(path = "{id}")
    public List<Material> getMaterialBySubjectId(@PathVariable("id") String id){
        return materialService.getMaterialById(id);
    }

    @PutMapping(path = "{id}")
    public Material updateMaterial(@PathVariable("id") String id,@Valid @NonNull @RequestBody Material material){
        return materialService.updateMaterial(id,material);
    }

    @DeleteMapping(path = "{id}")
    public String deleteMaterial(@PathVariable("id") String id){
        return materialService.deleteMaterial(id);
    }
    @DeleteMapping(path = "{subject}/{id}")
    public String deleteMaterialsBySubjectId(@PathVariable("id") String id){
        return materialService.deleteMaterialsBySubjectId(id);
    }

}
