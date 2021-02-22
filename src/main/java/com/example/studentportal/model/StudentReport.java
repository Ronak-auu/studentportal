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

    public StudentReport() {
    }

    public StudentReport(@Size(max = 500) String srId, String studentId, String externalId, String internalId, String projectDefinition, String workLanguage, String studentPercentage, String companyResources, String joinDate, String endDate) {
        this.srId = srId;
        this.studentId = studentId;
        this.externalId = externalId;
        this.internalId = internalId;
        this.projectDefinition = projectDefinition;
        this.workLanguage = workLanguage;
        this.studentPercentage = studentPercentage;
        this.companyResources = companyResources;
        this.joinDate = joinDate;
        this.endDate = endDate;
    }

    public String getSrId() {
        return srId;
    }

    public void setSrId(String srId) {
        this.srId = srId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getProjectDefinition() {
        return projectDefinition;
    }

    public void setProjectDefinition(String projectDefinition) {
        this.projectDefinition = projectDefinition;
    }

    public String getWorkLanguage() {
        return workLanguage;
    }

    public void setWorkLanguage(String workLanguage) {
        this.workLanguage = workLanguage;
    }

    public String getStudentPercentage() {
        return studentPercentage;
    }

    public void setStudentPercentage(String studentPercentage) {
        this.studentPercentage = studentPercentage;
    }

    public String getCompanyResources() {
        return companyResources;
    }

    public void setCompanyResources(String companyResources) {
        this.companyResources = companyResources;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
