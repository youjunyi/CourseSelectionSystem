package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Course;
import com.fidofi.entity.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
@Service
@Transactional
public interface CourseService {

    public ResultVO<String> create(Course course);

    public ResultVO<Course> update(Course course);

    public ResultVO<String> delete(Course course);

    public ResultVO<List<Course>> getAllCourses(Page page);

    public ResultVO<List<Course>> selectByTeacher(Page page, String teacherName);

    public ResultVO<List<Course>> selectByCategory(Page page, Integer categoryId);

    public ResultVO<List<Course>> selectByCourseName(Page page, String courseName);

    public ResultVO<Course> selectByCourseId(Integer courseId);

    public ResultVO<Integer> findCount();

}
