package com.itheima.mapper;

import com.itheima.pojo.StudentLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentLogMapper {

    @Insert("insert into student_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(StudentLog studentLog);
}
