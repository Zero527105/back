package com.itheima.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id; //ID
    private String operateEmpId; //操作人ID
    private LocalDateTime operateTime; //操作时间
    private String className; //类名
    private String methodName; //方法名
    private String methodParams; //方法请求参数
    private String returnValue; //返回值
    private Integer costTime; //执行耗时

    private String operateEmpName; //操作人姓名
}
