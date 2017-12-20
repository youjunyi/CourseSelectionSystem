package com.fidofi.dao.impl;

import com.fidofi.dao.SelectCoursesDao;
import com.fidofi.entity.Course;
import com.fidofi.entity.Selectcourses;
import com.fidofi.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/18.
 */
@Repository
@Transactional
public class SelectCoursesDaoImpl implements SelectCoursesDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 学生选课
     *
     * @param selectcourses
     */
    public void confirmCourse(Selectcourses selectcourses) {
        this.getCurrentSession().save(selectcourses);
    }

    /**
     * 学生退选
     *
     * @param selectcourses
     */
    public void cancelCourse(Selectcourses selectcourses) {
        this.getCurrentSession().delete(selectcourses);
    }

    /**
     * 返回该学生选的课程
     *
     * @param studentId
     * @return
     */
    public List<Course> getStudentCourses(String studentId) {
        String sql = "SELECT * from Course ,Selectcourses where Course .courseId=Selectcourses .courseId and Selectcourses .studentId=:n";

        Query query = this.getCurrentSession().createSQLQuery(sql).addEntity(Course.class);
        query.setParameter("n", studentId);
        List<Course> coursesList = query.list();
        return coursesList;
    }

    /**
     * 返回选该课程的所有学生
     *
     * @param courseId
     * @return
     */
    public List<Student> getStudentLists(Integer courseId) {
        String sql = "SELECT * from Student ,Selectcourses where Student .studentId=Selectcourses .studentId and Selectcourses .courseId=:n";
        Query query = this.getCurrentSession().createSQLQuery(sql).addEntity(Student.class);
        query.setParameter("n", courseId);
        List<Student> studentList = query.list();
        return studentList;
    }

    /**
     * 返回学生的选课课程数量，用于选课的条件判断
     *
     * @param studentId
     * @return
     */
    public Integer courseNum(String studentId) {
        String hql = "SELECT COUNT(courseId) FROM Selectcourses  WHERE studentId=:n";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter("n", studentId);
        List<Long> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }

    /**
     * 返回学生所选课程的总学分，用于选课的条件判断
     *
     * @param studentId
     * @return
     */
    public Double courseCreditNum(String studentId) {
        String hql = "SELECT SUM(credit) FROM Course WHERE courseId IN(SELECT courseId FROM Selectcourses WHERE studentId=:n)";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter("n", studentId);
        List<Double> list = query.list();
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return 0D;
    }
}
