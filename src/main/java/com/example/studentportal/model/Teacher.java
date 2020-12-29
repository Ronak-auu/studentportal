package com.example.studentportal.model;

import jdk.jfr.DataAmount;
import org.hibernate.annotations.GenericGenerator;

import javax.lang.model.element.Name;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="teacher")
public class Teacher {

    @Id
    private String teacherId;
    private String teacherName;
    private String teacherEmail;
    private String teacherGender;
    private String teacherDob;
    private String teacherPhone;
    private String teacherAddress;

    public Teacher() {
    }

    public Teacher(String teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(String teacherId, String teacherName, String teacherEmail, String teacherGender, String teacherDob, String teacherPhone, String teacherAddress) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherEmail = teacherEmail;
        this.teacherGender = teacherGender;
        this.teacherDob = teacherDob;
        this.teacherPhone = teacherPhone;
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    public String getTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherDob() {
        return teacherDob;
    }

    public void setTeacherDob(String teacherDob) {
        this.teacherDob = teacherDob;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }
}
