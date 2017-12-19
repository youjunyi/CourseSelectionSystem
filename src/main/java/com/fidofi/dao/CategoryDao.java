package com.fidofi.dao;

import com.fidofi.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fido on 2017/12/18.
 * 课程类别的数据库操作
 */

public interface CategoryDao {
    public void create(Category category);

    public void update(Category category);

    public void delete(Category category);

    public List<Category> getAllCategory();

    public Category getCategoryById(Integer categoryId);
    public Category getCategoryByName(String categoryName);
}
