package com.fidofi.VO;

import com.fidofi.entity.Category;
import com.fidofi.entity.Course;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 * 封装了类别及其下的课程
 */
public class CategoryAndCourses {

    private Category category;//类别
    private List<Course> courseList;//该类别的课程

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
