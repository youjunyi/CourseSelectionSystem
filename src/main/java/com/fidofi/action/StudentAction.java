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
    //此对象可以获得request,session
    private ActionContext cxt = ActionContext.getContext();

    @Autowired
    private StudentService studentService;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    //跳转到登录界面
    public String index() {
        return "Login";
    }

    //登录
    public String login() {
        ResultVO<Student> resultVO = studentService.login(student.getStudentId(), student.getStudentPassword());
        if (resultVO.getData() == null) {
            //登录不成功，返回错误信息
            cxt.put("loginMesg", resultVO.getMessage());
            return "Login";
        } else {
            //登录成功，将学生信息放入session
            cxt.getSession().put("student", resultVO.getData());
            return "Index";
        }
    }

    //跳转到选课界面
    public String selectCourses() {
        return "SelectCourses";
    }

    //跳转到个人信息界面
    public String informations() {
        return "Information";
    }

    //跳转到课程成绩界面
    public String coursesScore() {
        return "CoursesScore";
    }

    //处理个人信息更新
    public String updateInfo(){
        studentService.update(student);
        return "Information";
    }


}
