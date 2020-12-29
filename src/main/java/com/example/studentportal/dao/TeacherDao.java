package com.example.studentportal.dao;

import com.example.studentportal.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherDao extends CrudRepository<Teacher,String> {

   // Teacher findByName(String name);
}
