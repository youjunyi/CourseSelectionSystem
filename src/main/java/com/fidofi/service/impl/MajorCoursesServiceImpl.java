package com.fidofi.service.impl;

import com.fidofi.VO.CourseAndScore;
import com.fidofi.VO.ResultVO;
import com.fidofi.VO.StudentAndScore;
import com.fidofi.dao.CourseDao;
import com.fidofi.dao.MajorCoursesDao;
import com.fidofi.dao.StudentDao;
import com.fidofi.entity.Course;
import com.fidofi.entity.Majorcourses;
import com.fidofi.entity.Student;
import com.fidofi.service.MajorCoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fido on 2017/12/21.
 */
@Service
@Transactional
public class MajorCoursesServiceImpl implements MajorCoursesService {

    @Autowired
    private MajorCoursesDao majorCoursesDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private StudentDao studentDao;

    public ResultVO<List<CourseAndScore>> getByStudent(String studentId) {
        ResultVO<List<CourseAndScore>> resultVO;
        try {
            List<Majorcourses> majorcoursesList = majorCoursesDao.getByStudent(studentId);
            List<CourseAndScore> courseAndScoreList = new ArrayList<CourseAndScore>();
            if (majorcoursesList != null && majorcoursesList.size() > 0) {
                for (Majorcourses majorCourses : majorcoursesList) {
                    Course course = courseDao.selectByCourseId(majorCourses.getCourseId());
                    Double score = majorCourses.getScore();
                    CourseAndScore courseAndScore = new CourseAndScore(course, score);
                    courseAndScoreList.add(courseAndScore);
                }
                resultVO = ResultVO.createBySuccess("获取已修课程信息成功", courseAndScoreList);
            } else
                resultVO = ResultVO.createBySuccess("该学生暂未有已修课程");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取已修课程列表失败");
            return resultVO;
        }
    }

    public ResultVO<List<StudentAndScore>> getByCourse(Integer courseId) {
        ResultVO<List<StudentAndScore>> resultVO;
        try {
            List<Majorcourses> majorcoursesList = majorCoursesDao.getByCourse(courseId);
            List<StudentAndScore> studentAndScores = new ArrayList<StudentAndScore>();
            if (majorcoursesList != null && majorcoursesList.size() > 0) {
                for (Majorcourses majorcourses : majorcoursesList) {
                    Student student = studentDao.selectById(majorcourses.getStudentId());
                    Double score = majorcourses.getScore();
                    StudentAndScore studentAndScore = new StudentAndScore(student, score);
                    studentAndScores.add(studentAndScore);
                }
                resultVO = ResultVO.createBySuccess("获取已修学生列表成功", studentAndScores);
            } else
                resultVO = ResultVO.createBySuccess("该课程暂未有学生");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取已修课程列表失败");
            return resultVO;
        }
    }
}
