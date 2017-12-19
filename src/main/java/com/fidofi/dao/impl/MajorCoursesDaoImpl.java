package com.fidofi.dao.impl;

import com.fidofi.dao.MajorCoursesDao;
import com.fidofi.entity.Majorcourses;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/19.
 */
@Repository
@Transactional
public class MajorCoursesDaoImpl implements MajorCoursesDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * 根据学生编号查询该学生的已修所有课程
     *
     * @param studentId
     * @return
     */
    public List<Majorcourses> getByStudent(String studentId) {
        String hql = "from Majorcourses where studentId=:n";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter("n", studentId);
        List<Majorcourses> majorcoursesList = query.list();
        return majorcoursesList;
    }

    /**
     * 查询该课程下的所有学生
     *
     * @param courseId
     * @return
     */
    public List<Majorcourses> getByCourse(Integer courseId) {
        String hql = "from Majorcourses where courseId=:n";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter("n", courseId);
        List<Majorcourses> majorcoursesList = query.list();
        return majorcoursesList;
    }

    /**
     * 判断某个学生是否修了某门课程
     * 用于后续选课的先行课的判定
     *
     * @param courseId
     * @param studentId
     * @return
     */
    public boolean isMajor(Integer courseId, String studentId) {
        String hql = "from Majorcourses where courseId=:n and studentId=:m";
        Query query = this.getCurrentSession().createQuery(hql);
        query.setParameter("n", courseId);
        query.setParameter("m", studentId);
        Majorcourses majorcourses = (Majorcourses) query.uniqueResult();
        if (majorcourses == null) {
            return false;
        } else {
            return true;
        }
    }
}
