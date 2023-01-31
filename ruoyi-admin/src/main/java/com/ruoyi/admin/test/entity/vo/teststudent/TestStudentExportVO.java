package com.ruoyi.admin.test.entity.vo.teststudent;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class TestStudentExportVO {

    @Excel(name = "学生名称")
    private String studentName;

    @Excel(name = "年龄")
    private Integer studentAge;

    @Excel(name = "爱好", readConverterExp = "0=代码,1=音乐,2=电影")
    private String studentHobby;

    @Excel(name = "性别", dictType = "sys_user_sex")
    private String studentSex;

    @Excel(name = "状态", dictType = "sys_normal_disable")
    private String studentStatus;

    @Excel(name = "生日", width = 30, dateFormat = DatePattern.NORM_DATE_PATTERN)
    private Date studentBirthday;

    @Excel(name = "创建时间", width = 30, dateFormat = DatePattern.NORM_DATETIME_PATTERN)
    private Date createTime;

}
