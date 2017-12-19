package com.fidofi.utils;

import java.util.Random;
import java.util.UUID;

/**
 * Created by fido on 2017/12/19.
 * 生成学生10位学号
 * 正常情况下学号应该按学院，专业，姓名等排序规则生成，这里省略
 */
public class StudentIDUtils {

    public static String getStudentId(){
        Random random = new Random();
        String[] args={"3215","3115"};
        Integer number = random.nextInt(900000) + 100000;
        Integer index=random.nextInt(2);
        return args[index]+String.valueOf(number);
    }
}
