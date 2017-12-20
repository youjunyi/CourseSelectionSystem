package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.CourseDao;
import com.fidofi.entity.Course;
import com.fidofi.entity.Page;
import com.fidofi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    public ResultVO<String> create(Course course) {
        ResultVO<String> resultVO;
        try {
            courseDao.create(course);
            resultVO = ResultVO.createBySuccess("新增课程成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("新增课程失败");
            return resultVO;
        }
    }

    public ResultVO<Course> update(Course course) {
        ResultVO<Course> resultVO;
        try {
            Course newCourse = courseDao.update(course);
            resultVO = ResultVO.createBySuccess("更新课程成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("更新课程失败");
            return resultVO;
        }
    }

    public ResultVO<String> delete(Course course) {
        ResultVO<String> resultVO;
        try {
            courseDao.delete(course);
            resultVO = ResultVO.createBySuccess("删除课程成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("删除课程失败");
            return resultVO;
        }
    }

    public ResultVO<List<Course>> getAllCourses(Page page) {
        ResultVO<List<Course>> resultVO;
        try {
            List<Course> courseList = courseDao.selectCourses(page);
            if (courseList != null && courseList.size() > 0)
                resultVO = ResultVO.createBySuccess("查询课程列表成功", courseList);
            else
                resultVO = ResultVO.createBySuccess("暂无课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取课程列表失败");
            return resultVO;
        }
    }

    public ResultVO<List<Course>> selectByTeacher(Page page, String teacherName) {
        ResultVO<List<Course>> resultVO;
        try {
            List<Course> courseList = courseDao.selectByTeacher(page, teacherName);
            if (courseList != null && courseList.size() > 0)
                resultVO = ResultVO.createBySuccess("查询课程列表成功", courseList);
            else
                resultVO = ResultVO.createBySuccess("暂无课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取课程列表失败");
            return resultVO;
        }
    }

    public ResultVO<List<Course>> selectByCategory(Page page, Integer categoryId) {
        ResultVO<List<Course>> resultVO;
        try {
            List<Course> courseList = courseDao.selectByCategory(page, categoryId);
            if (courseList != null && courseList.size() > 0)
                resultVO = ResultVO.createBySuccess("查询课程列表成功", courseList);
            else
                resultVO = ResultVO.createBySuccess("暂无课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取课程列表失败");
            return resultVO;
        }
    }

    public ResultVO<List<Course>> selectByCourseName(Page page, String courseName) {
        ResultVO<List<Course>> resultVO;
        try {
            List<Course> courseList = courseDao.selectByCourseName(page, courseName);
            if (courseList != null && courseList.size() > 0)
                resultVO = ResultVO.createBySuccess("查询课程列表成功", courseList);
            else
                resultVO = ResultVO.createBySuccess("暂无课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取课程列表失败");
            return resultVO;
        }
    }

    public ResultVO<Course> selectByCourseId(Integer courseId) {
        ResultVO<Course> resultVO;
        try {
            Course course = courseDao.selectByCourseId(courseId);
            if (course != null)
                resultVO = ResultVO.createBySuccess("查询课程成功", course);
            else
                resultVO = ResultVO.createBySuccess("暂无此课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取课程失败");
            return resultVO;
        }
    }

    public ResultVO<Integer> findCount() {
        ResultVO<Integer> resultVO = ResultVO.createBySuccess(courseDao.findCount());
        return resultVO;
    }
}
