package com.itheima.service;

import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;

import java.util.List;

public interface StudentService {

    /**
     * 分页查询学生信息
     */
    PageResult<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 批量删除学生
     */
    void delete(List<Integer> ids);

    /**
     * 新增学生
     */
    void save(Student student);

    /**
     * 根据ID查询学生信息
     */
    Student getInfo(Integer id);

    /**
     * 修改学生信息
     */
    void updateById(Student student);

    /**
     * 违纪处理
     */
    void updateViolation(Integer id, Integer score);
}
