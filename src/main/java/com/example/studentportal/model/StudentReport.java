package com.example.studentportal.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="studentreport")
public class StudentReport {
    @Id @NotNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Size(max = 500)
    private String srId;
    @NotNull
    private String studentId;
    @NotNull
    private String externalId;
    @NotNull
    private String internalId;
    @NotNull
    private String projectDefinition;
    @NotNull
    private String workLanguage;
    @NotNull
    private String studentPercentage;
    @NotNull
    private String companyResources;
    @NotNull
    private String joinDate;
    @NotNull
    private String endDate;
}
