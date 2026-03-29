package com.itheima.service;

import com.itheima.exception.ClazzException;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    /**
     * 分页查询
     */
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 删除班级
     */
    void deleteById(Integer id) throws ClazzException;

    /**
     * 新增班级
     */
    void save(Clazz clazz);

    /**
     * 根据ID查询班级信息
     */
    Clazz getInfo(Integer id);

    /**
     * 修改班级
     */
    void updateById(Clazz clazz);

    /**
     * 查询所有班级
     */
    List<Clazz> list();
}

