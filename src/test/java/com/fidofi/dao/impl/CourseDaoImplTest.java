package com.fidofi.dao.impl;

import com.fidofi.dao.CategoryDao;
import com.fidofi.dao.CourseDao;
import com.fidofi.entity.Category;
import com.fidofi.entity.Course;
import com.fidofi.entity.Page;
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
public class CourseDaoImplTest extends TestCase {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CategoryDao categoryDao;

  //  @Test
    public void testCreate() throws Exception {
        Course course=new Course();
        course.setCourseName("数学建模");
        course.setCourseTime("周六八九十节");
        course.setCredit(1.5);
        course.setStudentNum(200);
        course.setPreviousId(5);
        course.setTeacherName("飞飞");
        course.setTerm(true);
        Category category=categoryDao.getCategoryById(3);
        course.setCategory(category);
        courseDao.create(course);
    }

    //@Test
    public void testUpdate() throws Exception {
        Course course=courseDao.getCourseById(2);
        course.setCourseName("数据结构");
        courseDao.update(course);
    }

   // @Test
    public void testDelete() throws Exception {
      Course course=courseDao.getCourseById(2);
      courseDao.delete(course);
    }

   // @Test
    public void testSelectCourses() throws Exception {
        Page page=new Page(1,courseDao.findCount());
        List<Course> course=courseDao.selectCourses(page);
        for(Course course1:course){
            System.out.println(course1);
        }
    }

   // @Test
    public void testSelectByTeacher() throws Exception {
        Page page=new Page(1,courseDao.findCount());
        List<Course> course=courseDao.selectByTeacher(page,"老张");
        for(Course course1:course){
            System.out.println(course1);
        }
    }

   // @Test
    public void testSelectByCategory() throws Exception {
        Page page=new Page(1,courseDao.findCount());
        List<Course> course=courseDao.selectByCategory(page,3);
        for(Course course1:course){
            System.out.println(course1);
        }
    }

   // @Test
    public void testSelectByCourseName() throws Exception {
         Page page=new Page(1,courseDao.findCount());
         List<Course> course=courseDao.selectByCourseName(page,"Java语言程序设计");
         for(Course course1:course){
             System.out.println(course1);
         }
    }

   // @Test
    public void testCancelCourse() throws Exception {
            courseDao.cancelCourse(1);
    }

    //@Test
    public void testSelectByCourseId() throws Exception {
           courseDao.confirmCourse(1);
    }

    public void testConfirmCourse() throws Exception {

    }

    //@Test
    public void testFindCount() throws Exception {
        Integer count=courseDao.findCount();
        System.out.println(count);
    }

    //@Test
    public void testGetCourseById() throws Exception {
        Course course=courseDao.getCourseById(1);
        System.out.println(course);
    }
}