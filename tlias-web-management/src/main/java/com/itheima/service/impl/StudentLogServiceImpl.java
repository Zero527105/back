package com.itheima.service.impl;

import com.itheima.mapper.StudentLogMapper;
import com.itheima.pojo.StudentLog;
import com.itheima.service.StudentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentLogServiceImpl implements StudentLogService {
    @Autowired
    private StudentLogMapper studentLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(StudentLog studentLog) {

        studentLogMapper.insert(studentLog);
    }
}
