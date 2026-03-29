package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Student;
import com.itheima.pojo.StudentLog;
import com.itheima.pojo.StudentQueryParam;
import com.itheima.service.StudentLogService;
import com.itheima.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentLogService studentLogService;

    /**
     * 分页查询学生信息
     */
    @Override
    public PageResult<Student> page(StudentQueryParam studentQueryParam) {
        PageHelper.startPage(studentQueryParam.getPage(), studentQueryParam.getPageSize());

        List<Student> studentList =studentMapper.list(studentQueryParam);

        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    /**
     * 批量删除学生信息
     */
    @Override
    public void delete(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    /**
     * 新增学生信息
     */
    @Override
    public void save(Student student) {
        try {
            student.setCreateTime(LocalDateTime.now());
            student.setUpdateTime(LocalDateTime.now());
            studentMapper.insert(student);
        }
        finally {
            StudentLog studentLog = new StudentLog(null, LocalDateTime.now(), "新增学生：" + student);
            studentLogService.insertLog(studentLog);
        }
    }

    /**
     * 根据ID查询学生信息
     */
    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getInfo(id);
    }

    /**
     * 修改学生信息
     */
    @Override
    public void updateById(Student student) {
        try {
            student.setUpdateTime(LocalDateTime.now());
            studentMapper.updateById(student);
        }
        finally {
            StudentLog studentLog = new StudentLog(null, LocalDateTime.now(), "修改学生：" + student);
            studentLogService.insertLog(studentLog);
        }
    }

    /**
     * 违纪处理
     */
    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateViolation(Integer id, Integer score) {
        Student student = studentMapper.getInfo(id);
        try {
            if(student == null){
                throw new RuntimeException("学生不存在");
            }
            if(score <= 0){
                throw new RuntimeException("扣分不能小于等于0");
            }
            student.setViolationCount((short) (student.getViolationCount() + 1));
            student.setViolationScore((short) (student.getViolationScore() + score));
            studentMapper.updateById(student);
        } finally {
            StudentLog studentLog = new StudentLog(null, LocalDateTime.now(), "学生违纪处理：" + student);
            studentLogService.insertLog(studentLog);
        }


    }
}
