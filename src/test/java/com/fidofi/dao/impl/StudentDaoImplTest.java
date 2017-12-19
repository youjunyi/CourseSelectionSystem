package com.fidofi.dao.impl;

import com.fidofi.dao.StudentDao;
import com.fidofi.entity.Page;
import com.fidofi.entity.Student;
import com.fidofi.utils.StudentIDUtils;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/19.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class StudentDaoImplTest extends TestCase {

    @Autowired
    private StudentDao studentDao;

    //@Test
    public void  testSave() throws Exception {
           Student student=new Student();
           student.setStudentId(StudentIDUtils.getStudentId());
           student.setStudentName("赵六");
           student.setAddress("G区");
           student.setPhone("15626154455");
           student.setStudentMajor("会计学");
           student.setStudentPassword(student.getStudentId().substring(student.getStudentId().length()-7));
           student.setStudentSex(true);
           studentDao.save(student);
    }

   // @Test
    public void testUpdate() throws Exception {
         Student student=studentDao.selectById("3215747653");
         student.setStudentName("王五");
         studentDao.update(student);
    }

    //@Test
    public void testSelectStudent() throws Exception {
        Page page=new Page(1,studentDao.findCount());
        List<Student> studentList=studentDao.selectStudent(page);
        for(Student student:studentList){
            System.out.println(student);
        }
    }

   // @Test
    public void testDelete() throws Exception {
        Student student=studentDao.selectById("31501f09c");
        studentDao.delete(student);
    }

 //   @Test
    public void testSelectById() throws Exception {
            Student student=studentDao.selectById("31501f09c");
            System.out.println(student);
    }

    //@Test
    public void testFindCount() throws Exception {
        System.out.println(studentDao.findCount());
    }

}