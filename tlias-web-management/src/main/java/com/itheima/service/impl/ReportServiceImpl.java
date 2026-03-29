package com.itheima.service.impl;

import com.itheima.mapper.ClazzMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.ClazzOption;
import com.itheima.pojo.DegreeData;
import com.itheima.pojo.DegreeOption;
import com.itheima.pojo.JobOption;
import com.itheima.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ClazzMapper clazzMapper;

    /**
     * 统计员工职位人数
     */
    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    /**
     * 统计员工性别人数
     */
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    /**
     * 统计学生学历人数
     */
    @Override
    public DegreeOption getStudentDegreeData() {
        List<Map<String, Object>> list = studentMapper.countStudentDegreeData();

        List<DegreeData> degreeDataList = list.stream()
                .map(dataMap -> new DegreeData(
                        (String) dataMap.get("name"),
                        ((Long) dataMap.get("value")).intValue()))
                .collect(Collectors.toList());

        return new DegreeOption(degreeDataList);
    }

    /**
     * 统计学生班级人数
     */
    @Override
    public ClazzOption getStudentCountData() {
        List<Map<String, Object>> list = studentMapper.countStudentClazzData();

        List<String> clazzList = list.stream()
                .map(dataMap -> (String) dataMap.get("clazz"))
                .collect(Collectors.toList());

        List<Integer> dataList = list.stream()
                .map(dataMap -> ((Long) dataMap.get("num")).intValue())
                .collect(Collectors.toList());

        return new ClazzOption(clazzList, dataList);
    }
}
