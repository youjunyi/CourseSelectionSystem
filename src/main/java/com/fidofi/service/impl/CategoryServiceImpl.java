package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.CategoryDao;
import com.fidofi.entity.Category;
import com.fidofi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public ResultVO<String> create(Category category) {
        ResultVO<String> resultVO;
        try {
            categoryDao.create(category);
            resultVO = ResultVO.createBySuccess("新增类别成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("新增类别失败");
            return resultVO;
        }
    }

    public ResultVO<String> update(Category category) {
        ResultVO<String> resultVO;
        try {
            categoryDao.update(category);
            resultVO = ResultVO.createBySuccess("更新类别成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("更新类别失败");
            return resultVO;
        }
    }

    public ResultVO<String> delete(Category category) {
        ResultVO<String> resultVO;
        try {
            categoryDao.delete(category);
            resultVO = ResultVO.createBySuccess("删除类别成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("删除类别失败");
            return resultVO;
        }
    }

    public ResultVO<List<Category>> getAllCategory() {
        ResultVO<List<Category>> resultVO;
        try {
            List<Category> categoryList = categoryDao.getAllCategory();
            if (categoryList != null && categoryList.size() > 0)
                resultVO = ResultVO.createBySuccess("获取类别列表成功", categoryList);
            else
                resultVO = ResultVO.createBySuccess("暂无类别");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取类别失败");
            return resultVO;
        }
    }

    public ResultVO<Category> getCategoryById(Integer categoryId) {
        ResultVO<Category> resultVO;
        try {
            Category category = categoryDao.getCategoryById(categoryId);
            if (category != null)
                resultVO = ResultVO.createBySuccess("获取类别成功", category);
            else
                resultVO = ResultVO.createBySuccess("找不到该类别");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取类别失败");
            return resultVO;
        }
    }

    public ResultVO<Category> getCategoryByName(String categoryName) {
        ResultVO<Category> resultVO;
        try {
            Category category = categoryDao.getCategoryByName(categoryName);
            if (category != null)
                resultVO = ResultVO.createBySuccess("获取类别成功", category);
            else
                resultVO = ResultVO.createBySuccess("找不到该类别");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取类别失败");
            return resultVO;
        }
    }
}
