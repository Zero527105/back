package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询班级信息
     */
    public List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /***
     * 根据ID删除班级信息
     */
    void deleteById(Integer id);

    /**
     * 新增班级信息
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into clazz(name, room, begin_date, end_date, master_id, subject, create_time, update_time) " +
            "values (#{name}, #{room}, #{beginDate}, #{endDate}, #{masterId}, #{subject}, #{createTime}, #{updateTime})")
    void insert(Clazz clazz);

    /**
     * 根据ID查询班级信息
     */
    Clazz getById(Integer id);

    /**
     * 根据ID更新班级信息
     */
    void update(Clazz clazz);

    /**
     * 查询班级下是否有学生
     */
    int countStudentsByClazzId(Integer clazzId);

    /**
     * 查询所有班级
     */
    @Select("select c.* from clazz c")
    List<Clazz> listAll();


}
