package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Course;
import com.fidofi.entity.Selectcourses;
import com.fidofi.entity.Student;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
public interface SelectionCoursesService {
    public ResultVO<String> confirmCourse(Selectcourses selectcourses);

    public ResultVO<String> cancelCourse(Selectcourses selectcourses);

    public ResultVO<List<Course>> getStudentCourses(String studentId);

    public ResultVO<List<Student>> getStudentLists(Integer courseId);
}
