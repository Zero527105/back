package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.exception.ClazzException;
import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzLog;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClazzLogService;
import com.itheima.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {


    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private ClazzLogService clazzLogService;

    /**
     * 分页查询班级信息
     */
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        List<Clazz> clazzList =clazzMapper.list(clazzQueryParam);

        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    /**
     * 根据ID删除班级
     */
    @Override
    public void deleteById(Integer id) throws ClazzException {
        int studentCount = clazzMapper.countStudentsByClazzId(id);
        if (studentCount > 0) {
            throw new ClazzException("对不起, 该班级下有学生, 不能直接删除!");
        }

        clazzMapper.deleteById(id);
    }

    /**
     * 新增班级
     */
    @Override
    public void save(Clazz clazz) {
        try {
            clazz.setCreateTime(LocalDateTime.now());
            clazz.setUpdateTime(LocalDateTime.now());
            clazzMapper.insert(clazz);
            }
        finally {
            ClazzLog clazzLog = new ClazzLog(null, LocalDateTime.now(), "新增班级：" + clazz);
            clazzLogService.insertLog(clazzLog);
        }
    }

    /**
     *·根据ID查询班级信息
     */
    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    /**
     * 根据ID更新班级信息
     */
    @Override
    public void updateById(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> list() {
        return clazzMapper.listAll();
    }
}
