package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.CourseDao;
import com.fidofi.dao.MajorCoursesDao;
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
    @Autowired
    private MajorCoursesDao majorCoursesDao;

    /**
     * 选课操作
     * 要同时操作两张表
     *
     * @param selectcourses
     * @return
     */
    public ResultVO<String> confirmCourse(Selectcourses selectcourses) {
        ResultVO<String> resultVO;
        try {
            //判断是否已经存在了该选课记录
            Selectcourses selectcourses_1 = selectCoursesDao.getSelectCourses(selectcourses.getStudentId(), selectcourses.getCourseId());
            if (selectcourses_1 != null) {
                resultVO = ResultVO.createBySuccess("该课程你已经选过了！");
                return resultVO;
            }
            Integer courseNum = selectCoursesDao.courseNum(selectcourses.getStudentId());
            //选课不能超过3门
            if (courseNum >= 3) {
                resultVO = ResultVO.createBySuccess("选课已满3门，请退选其他课程再继续选课！");
                return resultVO;
            }
            Double creditNum = selectCoursesDao.courseCreditNum(selectcourses.getStudentId());
            if (creditNum == null)
                creditNum = 0D;
            //查询该课程的信息，用作后续的条件判断
            Course course = courseDao.selectByCourseId(selectcourses.getCourseId());
            //选课的课程总学分不能超过5学分
            if (creditNum + course.getCredit() > 5) {
                resultVO = ResultVO.createBySuccess("总学分已经超过5学分，请选择其他课程！");
                return resultVO;
            }
            //选课的人数未满
            if (course.getSelectNum() == course.getStudentNum()) {
                resultVO = ResultVO.createBySuccess("选课人数已满，请选择其他课程！");
                return resultVO;
            }
            //判断是否有先行课
            if (course.getPreviousId() != null) {
                //判断先行课是否修了
                if (!majorCoursesDao.isMajor(course.getPreviousId(), selectcourses.getStudentId())) {
                    Course previousCourse = courseDao.selectByCourseId(course.getPreviousId());
                    resultVO = ResultVO.createBySuccess("请先修" + previousCourse.getCourseName() + "这门课");
                    return resultVO;
                }
            }
            selectCoursesDao.confirmCourse(selectcourses);
            courseDao.confirmCourse(selectcourses.getCourseId());
            resultVO = ResultVO.createBySuccess("选课成功");
            return resultVO;

        } catch (Exception e) {
            e.printStackTrace();
            //这里要抛出异常，不然配置的事务不起作用
            throw new RuntimeException("选课失败");
        }
    }

    /**
     * 退选操作
     * 要同时操作两张表
     *
     * @param selectcourses
     * @return
     */
    public ResultVO<String> cancelCourse(Selectcourses selectcourses) {
        ResultVO<String> resultVO;
        try {
            courseDao.cancelCourse(selectcourses.getCourseId());
            selectCoursesDao.cancelCourse(selectcourses);
            resultVO = ResultVO.createBySuccess("退选成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            //这里要抛出异常，不然配置的事务不起作用
            throw new RuntimeException("退选失败");
        }
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
