package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.CourseDao;
import com.fidofi.dao.SelectCoursesDao;
import com.fidofi.entity.Course;
import com.fidofi.entity.Selectcourses;
import com.fidofi.entity.Student;
import com.fidofi.service.SelectionCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
@Service
@Transactional
public class SeletCoursesServiceImpl implements SelectionCoursesService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private SelectCoursesDao selectCoursesDao;

    /**
     * 选课操作
     * 要同时操作两张表
     *
     * @param selectcourses
     * @return
     */
    public ResultVO<String> confirmCourse(Selectcourses selectcourses) {
        return null;
    }

    /**
     * 退选操作
     * 要同时操作两张表
     *
     * @param selectcourses
     * @return
     */
    public ResultVO<String> cancelCourse(Selectcourses selectcourses) {
        return null;
    }

    /**
     * 获取该学生选的所有课程
     *
     * @param studentId
     * @return
     */
    public ResultVO<List<Course>> getStudentCourses(String studentId) {
        ResultVO<List<Course>> resultVO;
        try {
            List<Course> courseList = selectCoursesDao.getStudentCourses(studentId);
            if (courseList != null && courseList.size() > 0)
                resultVO = ResultVO.createBySuccess("获取学生选课列表成功", courseList);
            else
                resultVO = ResultVO.createBySuccess("暂未有该学生的选课记录");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取该学生选课列表失败");
            return resultVO;
        }
    }

    /**
     * 获取选该门课程的学生列表
     *
     * @param courseId
     * @return
     */
    public ResultVO<List<Student>> getStudentLists(Integer courseId) {
        ResultVO<List<Student>> resultVO;
        try {
            List<Student> studentList = selectCoursesDao.getStudentLists(courseId);
            if (studentList != null && studentList.size() > 0)
                resultVO = ResultVO.createBySuccess("获取该课程的学生列表成功", studentList);
            else
                resultVO = ResultVO.createBySuccess("暂未查询有学生选修该课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取该课程的学生列表成功失败");
            return resultVO;
        }
    }
}
