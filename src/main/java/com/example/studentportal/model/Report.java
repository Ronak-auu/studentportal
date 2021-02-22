package com.example.studentportal.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="report")
public class Report {
    @Id @NotNull
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Size(max = 500)
    private String rId;
    @NotNull
    private String studentId;
    @NotNull
    private String reportNo;
    @NotNull
    private String reportLink;
    @NotNull
    private String reportDate;
    @NotNull
    private String externalStatus;
    @NotNull
    private String internalStatus;

    public Report() {
    }

    public Report(@Size(max = 500) String rId, String studentId, String reportNo, String reportLink, String reportDate, String externalStatus, String internalStatus) {
        this.rId = rId;
        this.studentId = studentId;
        this.reportNo = reportNo;
        this.reportLink = reportLink;
        this.reportDate = reportDate;
        this.externalStatus = externalStatus;
        this.internalStatus = internalStatus;
    }

    public Report(@Size(max = 500) String rId) {
        this.rId = rId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getReportNo() {
        return reportNo;
    }

    public void setReportNo(String reportNo) {
        this.reportNo = reportNo;
    }

    public String getReportLink() {
        return reportLink;
    }

    public void setReportLink(String reportLink) {
        this.reportLink = reportLink;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getExternalStatus() {
        return externalStatus;
    }

    public void setExternalStatus(String externalStatus) {
        this.externalStatus = externalStatus;
    }

    public String getInternalStatus() {
        return internalStatus;
    }

    public void setInternalStatus(String internalStatus) {
        this.internalStatus = internalStatus;
    }
}
