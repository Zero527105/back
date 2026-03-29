package com.itheima.service;

import com.itheima.pojo.Log;
import com.itheima.pojo.LogQueryParam;
import com.itheima.pojo.PageResult;

public interface LogService {

    /**
     * 分页查询日志信息
     */
    PageResult<Log> page(LogQueryParam logQueryParam);

}
