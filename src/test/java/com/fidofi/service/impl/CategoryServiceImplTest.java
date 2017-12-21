package com.fidofi.service.impl;

import com.fidofi.entity.Category;
import com.fidofi.service.CategoryService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by fido on 2017/12/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class CategoryServiceImplTest extends TestCase {

    @Autowired
    private CategoryService categoryService;

   // @Test
    public void testCreate() throws Exception {
        Category category = new Category();
        category.setCategoryName("测试类");
        System.out.println(categoryService.create(category));
    }

    //@Test
    public void testUpdate() throws Exception {
        Category category=new Category();
        category.setCategoryId(3);
        category.setCategoryName("工程技术基础类");
        System.out.println(categoryService.update(category));
    }

  //  @Test
    public void testDelete() throws Exception {
        Category category = new Category();
        category.setCategoryId(5);
        category.setCategoryName("测试类");
        System.out.println(categoryService.delete(category));
    }

    public void testGetAllCategory() throws Exception {

    }

    public void testGetCategoryById() throws Exception {

    }

    public void testGetCategoryByName() throws Exception {

    }

}