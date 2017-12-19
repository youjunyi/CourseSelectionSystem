package com.fidofi.dao.impl;

import com.fidofi.dao.SelectCoursesDao;
import com.fidofi.dao.StudentDao;
import com.fidofi.entity.Course;
import com.fidofi.entity.Selectcourses;
import com.fidofi.entity.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by fido on 2017/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SelectCoursesDaoImplTest extends TestCase {
    @Autowired
    private SelectCoursesDao selectCoursesDao;

    //@Test
    public void testConfirmCourse() throws Exception {
        Selectcourses selectCourses=new Selectcourses();
        selectCourses.setCourseId(3);
        selectCourses.setStudentId("3215703657");
        selectCoursesDao.confirmCourse(selectCourses);
    }

   // @Test
    public void testCancelCourse() throws Exception {
        Selectcourses selectCourses=new Selectcourses();
        selectCourses.setCourseId(1);
        selectCourses.setStudentId("3215747653");
        selectCoursesDao.cancelCourse(selectCourses);
    }

   //@Test
    public void testGetStudentCourses() throws Exception {
        List<Course> courseList=selectCoursesDao.getStudentCourses("3115638393");
        for(Course course:courseList){
            System.out.println(course);
        }
    }


    //@Test
    public void testGetStudentLists() throws Exception {
        List<Student> studentList=selectCoursesDao.getStudentLists(3);
        for(Student student:studentList){
            System.out.println(student);
        }
    }

}