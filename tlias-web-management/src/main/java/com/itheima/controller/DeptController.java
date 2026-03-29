package com.itheima.controller;


import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {


    @Autowired
    private DeptService deptService;
    /**
     * 查询部门
     */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    //@Log
    //@DeleteMapping("/{id}")
    //public Result delete(@PathVariable Integer id) throws Exception {
    //    log.info("根据ID删除部门：{}", id);
    //    try {
    //        deptService.deleteById(id);
    //        return Result.success();
    //    } catch (RuntimeException e) {
    //        return Result.error(e.getMessage());
    //    }
    //}
    @Log
    @DeleteMapping
    public Result delete(@RequestParam Integer id) throws Exception {
        log.info("根据ID删除部门：{}", id);
        try {
            deptService.deleteById(id);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    /**
     * 新增部门
     */
    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}", dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门
     */
    @Log
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据ID查询部门：{}", id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    //@Log
    //@GetMapping
    //public Result getInfo(@RequestParam Integer id){
    //    log.info("根据ID查询部门：{}", id);
    //    Dept dept = deptService.getById(id);
    //    return Result.success(dept);
    //}

    /**
     * 修改部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门： {}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
