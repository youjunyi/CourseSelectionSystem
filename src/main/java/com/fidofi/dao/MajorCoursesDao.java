package com.fidofi.dao;

import com.fidofi.entity.Majorcourses;

import java.util.List;

/**
 * Created by fido on 2017/12/19.
 * 学生已修课程的数据库操作
 */
public interface MajorCoursesDao {

    public List<Majorcourses> getByStudent(String studentId);

    public List<Majorcourses> getByCourse(Integer courseId);

    public boolean isMajor(Integer courseId, String studentId);

}
