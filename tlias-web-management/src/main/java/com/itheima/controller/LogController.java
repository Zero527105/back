package com.itheima.controller;

import com.itheima.pojo.*;
import com.itheima.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;
    @GetMapping("/page")
    public Result page(LogQueryParam logQueryParam){
        log.info("分页查询：{}", logQueryParam);
        PageResult<Log> pageResult = logService.page(logQueryParam);
        return Result.success(pageResult);
    }
}
