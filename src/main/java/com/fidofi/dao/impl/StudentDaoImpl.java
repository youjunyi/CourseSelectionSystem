package com.fidofi.dao.impl;

import com.fidofi.dao.StudentDao;
import com.fidofi.entity.Course;
import com.fidofi.entity.Page;
import com.fidofi.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/16.
 */
@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }
    /**
     * 录入学生账号
     *
     * @param student
     */
    public void save(Student student) {
      this.getCurrentSession().save(student);
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return
     */
    public Student update(Student student) {
        this.getCurrentSession().update(student);
        Student newStudent = this.selectById(student.getStudentId());
        return newStudent;
    }

    /**
     * 分页查询学生
     *
     * @param page
     * @return
     */
    public List<Student> selectStudent(Page page) {
        String hql="from Student ";
        Query query=this.getCurrentSession().createQuery(hql);
        query.setFirstResult(page.getStartIndex());
        query.setMaxResults(page.getPageSize());
        List<Student> studentList =query.list();
        return studentList;
    }

    /**
     * 删除学生
     *
     * @param student
     */
    public void delete(Student student) {
        this.getCurrentSession().delete(student);
    }

    /**
     * 根据学号查询
     *
     * @param studentId
     * @return
     */
    public Student selectById(String studentId) {
      String hql="from Student where studentId=:n";
      Query query=this.getCurrentSession().createQuery(hql);
      query.setParameter("n",studentId);
      Student student=(Student) query.uniqueResult();
      return student;
    }

    /**
     * 查找总记录数，分页需要用到
     *
     * @return
     */
    public int findCount() {
        String hql = "select count(*) from Student";
        List<Long> list = this.getCurrentSession().createQuery(hql).list();
        if (list != null && list.size() > 0) {
            return list.get(0).intValue();
        }
        return 0;
    }
}
