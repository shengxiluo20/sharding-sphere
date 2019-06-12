package com.join.shardingsphere.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.join.shardingsphere.entity.Teacher;
import com.join.shardingsphere.entity.User;
import com.join.shardingsphere.mapper.TeacherMapper;
import com.join.shardingsphere.mapper.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname UserController
 * @Description 用户测试控制类
 * @Author 李号东 lihaodongmail@163.com
 * @Date 2019-05-26 17:36
 * @Version 1.0
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;


    @Resource
    private TeacherMapper teacherMapper;


    @GetMapping("/select")
    public List<User> select() {
        LambdaQueryWrapper<User> gt = Wrappers.<User>lambdaQuery().gt(User::getId, 3);
        gt.orderByAsc(User::getAge);

        //IPage<User> userIPage = userMapper.selectPage(new Page<User>(2L, 2L), gt);

        List<User> users = userMapper.selectList(gt);
        return users;
    }


    int a = 17;

    @GetMapping("/insert")
    public int insert(User user) {


        user.setId(a++);
        user.setAge(123);

        return userMapper.insert(user);
    }


    @GetMapping("/teacher")
    public int insert() {
        Teacher teacher = new Teacher();

        teacher.setId(a++);
        teacher.setName("" + 123);


        return teacherMapper.insert(teacher);
    }


    @GetMapping("/teacher/select")
    public List<Teacher> eachersel() {

        Teacher teacher1 = teacherMapper.selectById(17);
        LambdaQueryWrapper<Teacher> gt = Wrappers.<Teacher>lambdaQuery().eq(Teacher::getName, 1231);

        List<Teacher> teachers = teacherMapper.selectList(gt);
        return teachers;
    }
}
