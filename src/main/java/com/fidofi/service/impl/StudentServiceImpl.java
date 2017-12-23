package com.fidofi.service.impl;

import com.fidofi.VO.ResultVO;
import com.fidofi.dao.StudentDao;
import com.fidofi.entity.Page;
import com.fidofi.entity.Student;
import com.fidofi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    public ResultVO<String> create(Student student) {
        ResultVO<String> resultVO;
        try {
            studentDao.save(student);
            resultVO = ResultVO.createBySuccess("录入学生成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("录入学生失败，请检查信息!");
            return resultVO;
        }
    }

    public ResultVO<Student> update(Student student) {
        ResultVO<Student> resultVO;
        try {
            Student newStudent = studentDao.update(student);
            resultVO = ResultVO.createBySuccess("更新学生信息成功", newStudent);
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("更新学生信息失败，请检查信息!");
            return resultVO;
        }
    }

    public ResultVO<String> delete(Student student) {
        ResultVO<String> resultVO;
        try {
            studentDao.delete(student);
            resultVO = ResultVO.createBySuccess("删除学生成功");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("删除学生失败");
            return resultVO;
        }
    }

    public ResultVO<List<Student>> getAllStudent(Page page) {
        ResultVO<List<Student>> resultVO;
        try {
            List<Student> studentList = studentDao.selectStudent(page);
            if (studentList != null && studentList.size() > 0)
                resultVO = ResultVO.createBySuccess("获取学生列表成功", studentList);
            else
                resultVO = ResultVO.createBySuccess("暂未录入学生");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取学生列表失败");
            return resultVO;
        }
    }

    public ResultVO<Student> selectById(String studentId) {
        ResultVO<Student> resultVO;
        try {
            Student student = studentDao.selectById(studentId);
            if (student != null)
                resultVO = ResultVO.createBySuccess("查询学生成功", student);
            else
                resultVO = ResultVO.createBySuccess("不存在该学生");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("获取学生信息失败");
            return resultVO;
        }
    }

    public ResultVO<Integer> findCount() {
        ResultVO<Integer> resultVO = ResultVO.createBySuccess(studentDao.findCount());
        return resultVO;
    }

    public ResultVO<Student> login(String studentId, String studentPassword) {
        ResultVO<Student> resultVO;
        try {
            Student student = studentDao.login(studentId, studentPassword);
            if (student == null) {
                resultVO = ResultVO.createBySuccess("学号或密码错误，请检查");
                return resultVO;
            }
            resultVO = ResultVO.createBySuccess("登陆成功", student);
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("登录出现异常");
            return resultVO;
        }
    }

    public ResultVO<String> changePassword(String studentId, String studentPassword) {
        ResultVO<String> resultVO;
        try {
            studentDao.changePassword(studentId, studentPassword);
            resultVO = ResultVO.createBySuccess("更改密码成功，请重新登录");
            return resultVO;
        } catch (Exception e) {
            e.printStackTrace();
            resultVO = ResultVO.createByError("更改密码出现异常");
            return resultVO;
        }
    }
}
