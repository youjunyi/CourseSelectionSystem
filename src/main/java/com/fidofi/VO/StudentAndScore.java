package com.fidofi.VO;

import com.fidofi.entity.Student;

/**
 * Created by fido on 2017/12/21.
 * 封装了已修学生和分数
 */
public class StudentAndScore {
    private Student student;
    private Double score;

    public StudentAndScore() {
    }

    public StudentAndScore(Student student, Double score) {
        this.student = student;
        this.score = score;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentAndScore{" +
                "student=" + student +
                ", score=" + score +
                '}';
    }
}
