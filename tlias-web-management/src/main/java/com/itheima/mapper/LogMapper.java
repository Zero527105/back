package com.itheima.mapper;

import com.itheima.pojo.Log;
import com.itheima.pojo.LogQueryParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    /**
     * 分页查询日志信息
     */
    public List<Log> list(LogQueryParam logQueryParam);
}
