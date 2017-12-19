package com.fidofi.dao;

import com.fidofi.entity.Page;
import com.fidofi.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fido on 2017/12/16.
 * 学生相关的数据库操作
 */

public interface StudentDao {
    public void save(Student student);

    public Student update(Student student);

    public List<Student> selectStudent(Page page);

    public void delete(Student student);

    public Student selectById(String studentId);

    public int findCount();

}
