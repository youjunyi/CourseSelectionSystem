package com.fidofi.action;

import com.fidofi.VO.ResultVO;
import com.fidofi.entity.Student;
import com.fidofi.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by fido on 2017/12/21.
 * 学生端action
 */
@Controller
public class StudentAction extends ActionSupport {
    private Student student;

    @Autowired
    private StudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    //首页
    public String studentIndex() {
        return "Login";
    }

    //登录
    public String login() {
        ResultVO<Student> resultVO = studentService.login(student.getStudentId(), student.getStudentPassword());
        if (resultVO.getData() == null) {
            ActionContext cxt = ActionContext.getContext();
            cxt.put("loginMesg", resultVO.getMessage());
            return "Login";
        } else
            return "Index";
    }
}
