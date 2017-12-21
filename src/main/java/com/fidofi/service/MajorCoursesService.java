package com.fidofi.service;

import com.fidofi.VO.CourseAndScore;
import com.fidofi.VO.ResultVO;
import com.fidofi.VO.StudentAndScore;
import com.fidofi.entity.Majorcourses;

import java.util.List;

/**
 * Created by fido on 2017/12/21.
 */
public interface MajorCoursesService {

    public ResultVO<List<CourseAndScore>> getByStudent(String studentId);

    public ResultVO<List<StudentAndScore>> getByCourse(Integer courseId);
}
