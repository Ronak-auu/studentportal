package com.example.studentportal.dao;

import com.example.studentportal.model.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ExamResultDao extends JpaRepository<ExamResult,String> {

    @Query(value = "SELECT * FROM ExamResult e WHERE e.examType = :type AND e.studentId = :id",
            nativeQuery = true)
    List<ExamResult> getResultByIdAndType(@Param("id") String id, @Param("type") String type);

    @Query(value = "SELECT * FROM ExamResult e WHERE e.examType = :type AND e.studentId = :studentid " +
            "AND e.subjectId = :subjectid",
            nativeQuery = true)
    String checkResultExist(@Param("studentid") String studentid,@Param("subjectid")String subjectid,@Param("type") String type);

    @Query(value = "SELECT * FROM Student s WHERE s.studentId = :studentid",nativeQuery = true)
    String checkStudentExist(@Param("studentid") String studentid);

    @Query(value = "SELECT * FROM Subject s WHERE s.subjectId = :subjectid",nativeQuery = true)
    String checkSubjectExist(@Param("subjectid") String subjectid);



}
