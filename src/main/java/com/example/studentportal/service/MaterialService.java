package com.example.studentportal.service;

import com.example.studentportal.dao.MaterialDao;
import com.example.studentportal.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MaterialService {
    @Autowired
    private MaterialDao materialDao;

    public String addMaterial(Material material) {
        if (materialDao.checkSubjectExists(material.getSubjectId()) != null) {
            materialDao.save(material);
            return "Added";
        } else {
            return "Subject not exists";
        }
    }

    public List<Material> getMaterialById(String id){
        return materialDao.getMaterialById(id);
    }

    public Material updateMaterial(String id,Material material){
        Material existingMaterial = materialDao.findById(id).orElse(null);
        existingMaterial.setMaterialLink(material.getMaterialLink());
        existingMaterial.setMaterialDescription(material.getMaterialDescription());
        existingMaterial.setSubjectId(material.getSubjectId());
        if (materialDao.checkSubjectExists(material.getSubjectId()) != null) {
            return materialDao.save(existingMaterial);
        } else {
            return null;
            // Subject exists
        }

    }

    public String deleteMaterial(String id){
        materialDao.deleteById(id);
        return "Material Removed  !" + id ;
    }

    public String deleteMaterialsBySubjectId(String id){
        materialDao.deleteBySubjectId(id);
        return "Materials Removed !";
    }
}
