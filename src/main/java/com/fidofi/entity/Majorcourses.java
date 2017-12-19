package com.fidofi.entity;

import javax.persistence.*;

/**
 * Created by fido on 2017/12/16.
 */
@Entity
@IdClass(MajorcoursesPK.class)
public class Majorcourses {
    private String studentId;
    private int courseId;
    private double score;

    @Id
    @Column(name = "studentId", nullable = false, length = 20)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Id
    @Column(name = "courseId", nullable = false)
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "score", nullable = false, precision = 0)
    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Majorcourses that = (Majorcourses) o;

        if (courseId != that.courseId) return false;
        if (Double.compare(that.score, score) != 0) return false;
        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + courseId;
        temp = Double.doubleToLongBits(score);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Majorcourses{" +
                "studentId='" + studentId + '\'' +
                ", courseId=" + courseId +
                ", score=" + score +
                '}';
    }
}
