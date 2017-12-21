package com.fidofi.service.impl;

import com.fidofi.entity.Course;
import com.fidofi.entity.Selectcourses;
import com.fidofi.service.SelectionCoursesService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by fido on 2017/12/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class SeletCoursesServiceImplTest extends TestCase {

    @Autowired
    private SelectionCoursesService selectionCoursesService;

   // @Test
    public void testConfirmCourse() throws Exception {
        Selectcourses selectcourses=new Selectcourses();
        selectcourses.setCourseId(1);
        selectcourses.setStudentId("3215703657");
        System.out.println(selectionCoursesService.confirmCourse(selectcourses));
    }

   // @Test
    public void testCancelCourse() throws Exception {
        Selectcourses selectcourses=new Selectcourses();
        selectcourses.setCourseId(1);
        selectcourses.setStudentId("3215703657");
        System.out.println(selectionCoursesService.cancelCourse(selectcourses));
    }

    //@Test
    public void testGetStudentCourses() throws Exception {
        System.out.println(selectionCoursesService.getStudentCourses("311563833"));
    }

 //   @Test
    public void testGetStudentLists() throws Exception {
        System.out.println(selectionCoursesService.getStudentLists(3));
    }

}