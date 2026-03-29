package com.itheima.mapper;

import com.itheima.pojo.ClazzLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClazzLogMapper {

    @Insert("insert into clazz_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(ClazzLog clazzLog);

}
