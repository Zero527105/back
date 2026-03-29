package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    /**
     * 分页查询学生信息
     */
    public List<Student> list(StudentQueryParam studentQueryParam);

    /**
     * 删除学生
     */
    void deleteByIds(List<Integer> ids);

    /**
     * 新增学生
     */
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into student(name, no, gender, phone, id_card, is_college, address, degree, graduation_date, clazz_id, create_time, update_time) " +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void insert(Student student);

    /**
     * 根据ID查询学生信息
     */
    Student getInfo(Integer id);

    /**
     * 修改学生信息
     */
    void updateById(Student student);

    /**
     * 统计学生学历人数
     */
    @MapKey("degree")
    List<Map<String, Object>> countStudentDegreeData();

    /**
     * 统计学生班级人数
     */
    @MapKey("clazz_id")
    List<Map<String, Object>> countStudentClazzData();
}
