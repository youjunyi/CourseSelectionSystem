package com.fidofi.dao.impl;

import com.fidofi.dao.CategoryDao;
import com.fidofi.entity.Category;
import com.fidofi.entity.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by fido on 2017/12/18.
 */


@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public void create(Category category) {
        this.getCurrentSession().save(category);
    }

    public void update(Category category) {
        this.getCurrentSession().update(category);
    }

    public void delete(Category category) {
        this.getCurrentSession().delete(category);
    }

    public List<Category> getAllCategory() {
        String hql = "from Category";
        List<Category> categoryList = this.getCurrentSession().createQuery(hql).list();
        return categoryList;
    }

    public Category getCategoryById(Integer categoryId) {
        String hql="from Category where categoryId=:n";
        Query query=this.getCurrentSession().createQuery(hql);
        //条件查询
        query.setParameter("n",categoryId);
        Category category=(Category) query.uniqueResult();
        return category;
    }

    public Category getCategoryByName(String categoryName) {
        String hql="from Category where categoryName=:n";
        Query query=this.getCurrentSession().createQuery(hql);
        //条件查询
        query.setParameter("n",categoryName);
        Category category=(Category) query.uniqueResult();
        return category;
    }
}
