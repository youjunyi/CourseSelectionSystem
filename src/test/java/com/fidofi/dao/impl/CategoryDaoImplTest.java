package com.fidofi.dao.impl;

import com.fidofi.dao.CategoryDao;
import com.fidofi.entity.Category;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by fido on 2017/12/18.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CategoryDaoImplTest {

    @Autowired
    private CategoryDao categoryDao;


   //@Test
    public void testCreate() throws Exception {
        Category category = new Category();
        category.setCategoryName("工程技术类");
        categoryDao.create(category);

    }
   // @Test
    public void testUpdate() throws Exception {
        Category category=new Category();
        category.setCategoryId(2);
        category.setCategoryName("自然科学类");
        categoryDao.update(category);
    }

  //  @Test
    public void testDelete() throws Exception {
        Category category = new Category();
        category.setCategoryId(1);
        category.setCategoryName("人文科学类");
        categoryDao.delete(category);
    }

  //  @Test
    public void testGetAllCategory() throws Exception {
        List<Category> categoryList=categoryDao.getAllCategory();
        for(Category category:categoryList){
            System.out.println(category);
        }
    }

    //@Test
    public void testGETCategoryById() throws Exception {
         Category category=categoryDao.getCategoryById(2);
        System.out.println(category);
    }
  //  @Test
    public void testGETCategoryByName() throws Exception {
          Category category=categoryDao.getCategoryByName("自然科学类");
        System.out.println(category);
    }
}