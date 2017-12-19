package com.fidofi.dao.impl;

import com.fidofi.dao.MajorCoursesDao;
import com.fidofi.entity.Majorcourses;
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
public class MajorCoursesDaoImplTest extends TestCase {

    @Autowired
    private MajorCoursesDao majorCoursesDao;

    //@Test
    public void testGetByStudent() throws Exception {
          List<Majorcourses> majorcoursesList= majorCoursesDao.getByStudent("3215703657");
          for(Majorcourses majorcourses:majorcoursesList){
              System.out.println(majorcourses);
          }
    }

  //  @Test
    public void testGetByCourse() throws Exception {
        List<Majorcourses> majorcoursesList= majorCoursesDao.getByCourse(5);
        for(Majorcourses majorcourses:majorcoursesList){
            System.out.println(majorcourses);
        }
    }

   // @Test
    public void testIsMajor() throws Exception {
        System.out.println(majorCoursesDao.isMajor(2,"3215703657"));
    }

}