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
    private String externalId;
    @NotNull
    private String internalId;
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
}
