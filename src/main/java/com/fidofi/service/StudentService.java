package com.fidofi.service;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Page;
import com.fidofi.entity.Student;

import java.util.List;

/**
 * Created by fido on 2017/12/20.
 */

public interface StudentService {

    public ResultVO<String> create(Student student);

    public ResultVO<Student> update(Student student);

    public ResultVO<String> delete(Student student);

    public ResultVO<List<Student>> getAllStudent(Page page);

    public ResultVO<Student> selectById(String studentId);

    public ResultVO<Integer> findCount();

    public ResultVO<Student> login(String studentId, String studentPassword);

}
