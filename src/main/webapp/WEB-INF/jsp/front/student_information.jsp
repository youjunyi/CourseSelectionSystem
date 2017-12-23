<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>学生个人信息</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" style="margin-top: 20px">
            <form role="form" method="post" action="/student_updateInfo"
                  style="margin-left: 300px">
                <div class="form-group">
                    <label>学号：</label>
                    <input type="text" class="form-control" name="student.studentId"
                           style="width:160px;display: inline-block" readonly
                           value="<s:property value="#session.student.studentId"/>"/>
                    <label>姓名：</label><input type="text" class="form-control" name="student.studentName"
                                             style="width:100px;display: inline-block" readonly
                                             value="<s:property value="#session.student.studentName"/>"/>
                    <label>性别：</label>
                    <s:if test="#session.student.sex==true">
                        <input type="text" class="form-control" name="student.studentSex"
                               style="width:80px;display: inline-block"
                               readonly value="男">
                    </s:if>
                    <s:else>
                        <input type="text" class="form-control" name="student.studentSex"
                               style="width:80px;display: inline-block"
                               readonly value="女">
                    </s:else>
                </div>
                <div class="from-group">
                    <label>专业：</label>
                    <input type="text" class="form-control" name="student.studentMajor"
                           style="width:120px;display: inline-block"
                           readonly value="<s:property value="#session.student.studentMajor"/>">
                </div>
                <div class="form-group" style="margin-top: 10px">
                    <label>家庭地址：</label>
                    <input type="text" class="form-control" name="student.address"
                           style="width:200px;display: inline-block"
                           value="<s:property value="#session.student.address"/>">
                    <label>电话号码：</label>
                    <input type="text" class="form-control" name="student.phone"
                           style="width:160px;display: inline-block"
                           value="<s:property value="#session.student.phone"/>">
                </div>
                <button type="submit" class="btn btn-default" style="text-align: center">保存</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
