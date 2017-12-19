package com.fidofi.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by fido on 2017/12/16.
 */
@Entity
public class Student {
    private String studentId;
    private String studentName;
    private String studentPassword;
    private Boolean studentSex;
    private String studentMajor;
    private String address;
    private String phone;

    @Id
    @Column(name = "studentId", nullable = false, length = 20)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "studentName", nullable = false, length = 5)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "studentPassword", nullable = false, length = 20)
    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    @Basic
    @Column(name = "studentSex", nullable = true)
    public Boolean getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(Boolean studentSex) {
        this.studentSex = studentSex;
    }

    @Basic
    @Column(name = "studentMajor", nullable = false, length = 20)
    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String studentMajor) {
        this.studentMajor = studentMajor;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 150)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (studentId != null ? !studentId.equals(student.studentId) : student.studentId != null) return false;
        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;
        if (studentPassword != null ? !studentPassword.equals(student.studentPassword) : student.studentPassword != null)
            return false;
        if (studentSex != null ? !studentSex.equals(student.studentSex) : student.studentSex != null) return false;
        if (studentMajor != null ? !studentMajor.equals(student.studentMajor) : student.studentMajor != null)
            return false;
        if (address != null ? !address.equals(student.address) : student.address != null) return false;
        if (phone != null ? !phone.equals(student.phone) : student.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (studentPassword != null ? studentPassword.hashCode() : 0);
        result = 31 * result + (studentSex != null ? studentSex.hashCode() : 0);
        result = 31 * result + (studentMajor != null ? studentMajor.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", studentSex=" + studentSex +
                ", studentMajor='" + studentMajor + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
