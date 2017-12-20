package com.fidofi.dao;

import com.fidofi.entity.Course;
import com.fidofi.entity.Selectcourses;
import com.fidofi.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fido on 2017/12/18.
 * 学生选课表的数据库操作
 */

public interface SelectCoursesDao {
    public void confirmCourse(Selectcourses selectcourses);

    public void cancelCourse(Selectcourses selectcourses);

    public List<Course> getStudentCourses(String studentId);

    public List<Student> getStudentLists(Integer courseId);

    public Integer courseNum(String studentId);

    public Double courseCreditNum(String studentId);
}
