package com.fidofi.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by fido on 2017/12/16.
 */
@Entity
public class Course {
    private int courseId;
    private String courseName;
    private double credit;
    private String teacherName;
    private int studentNum;
    private String courseTime;
    private boolean term;
    private Integer selectNum;
    private Category category;
    private Integer previousId;

    @Id
    @Column(name = "courseId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "courseName", nullable = false, length = 20)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "credit", nullable = false, precision = 0)
    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Basic
    @Column(name = "teacherName", nullable = false, length = 6)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "studentNum", nullable = false)
    public int getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(int studentNum) {
        this.studentNum = studentNum;
    }

    @Basic
    @Column(name = "courseTime", nullable = false, length = 20)
    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    @Basic
    @Column(name = "term", nullable = false)
    public boolean isTerm() {
        return term;
    }

    public void setTerm(boolean term) {
        this.term = term;
    }

    @Basic
    @Column(name = "selectNum", nullable = true,columnDefinition="INT default 0")
    public Integer getSelectNum() {
        return selectNum;
    }

    public void setSelectNum(Integer selectNum) {
        this.selectNum = selectNum;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "previousId",nullable = true)
    public Integer getPreviousId() {
        return previousId;
    }

    public void setPreviousId(Integer previousId) {
        this.previousId = previousId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (courseId != course.courseId) return false;
        if (Double.compare(course.credit, credit) != 0) return false;
        if (studentNum != course.studentNum) return false;
        if (term != course.term) return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null) return false;
        if (teacherName != null ? !teacherName.equals(course.teacherName) : course.teacherName != null) return false;
        if (courseTime != null ? !courseTime.equals(course.courseTime) : course.courseTime != null) return false;
        if (selectNum != null ? !selectNum.equals(course.selectNum) : course.selectNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = courseId;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + studentNum;
        result = 31 * result + (courseTime != null ? courseTime.hashCode() : 0);
        result = 31 * result + (term ? 1 : 0);
        result = 31 * result + (selectNum != null ? selectNum.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", credit=" + credit +
                ", teacherName='" + teacherName + '\'' +
                ", studentNum=" + studentNum +
                ", courseTime='" + courseTime + '\'' +
                ", term=" + term +
                ", selectNum=" + selectNum +
                ", category=" + category +
                ", previousId=" + previousId +
                '}';
    }
}
