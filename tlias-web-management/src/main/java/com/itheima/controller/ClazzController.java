package com.itheima.controller;

import com.itheima.exception.ClazzException;
import com.itheima.pojo.*;
import com.itheima.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理Controller
 */
@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     * 分页查询班级信息
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询：{}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) throws Exception {
        log.info("删除班级：{}", id);

        try {
            clazzService.deleteById(id);
            return Result.success();
        } catch (ClazzException e) {
            return Result.error(e.getMessage());
        }

    }

    /**
     * 新增班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("新增班级：{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询班级信息：{}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级：{}", clazz);
        try {
            clazzService.updateById(clazz);
            return Result.success();
        } catch (Exception e) {
            return Result.error(e.getMessage());
        }
    }
    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询所有班级：");
        List<Clazz> clazzList = clazzService.list();
        return Result.success(clazzList);
    }
}
