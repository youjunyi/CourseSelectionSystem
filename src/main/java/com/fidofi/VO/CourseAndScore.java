package com.fidofi.VO;

import com.fidofi.entity.Course;
import com.fidofi.entity.Student;

/**
 * Created by fido on 2017/12/21.
 * 封装了已修课程和分数
 */
public class CourseAndScore {
    private Course course;
    private Double score;

    public CourseAndScore() {
    }

    public CourseAndScore(Course course, Double score) {
        this.course = course;
        this.score = score;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CourseAndScore{" +
                "course=" + course +
                ", score=" + score +
                '}';
    }
}
