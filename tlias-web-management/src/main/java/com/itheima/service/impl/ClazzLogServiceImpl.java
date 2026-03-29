package com.itheima.service.impl;

import com.itheima.mapper.ClazzLogMapper;
import com.itheima.pojo.ClazzLog;
import com.itheima.service.ClazzLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClazzLogServiceImpl implements ClazzLogService {

    @Autowired
    private ClazzLogMapper clazzLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(ClazzLog clazzLog) {

        clazzLogMapper.insert(clazzLog);
    }
}