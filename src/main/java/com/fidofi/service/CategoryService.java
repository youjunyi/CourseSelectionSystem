package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Category;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
public interface CategoryService {
    public ResultVO<String> create(Category category);

    public ResultVO<String> update(Category category);

    public ResultVO<String> delete(Category category);

    public ResultVO<List<Category>> getAllCategory();

    public ResultVO<Category> getCategoryById(Integer categoryId);

    public ResultVO<Category> getCategoryByName(String categoryName);

}
