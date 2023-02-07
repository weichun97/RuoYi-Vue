package com.ruoyi.admin.test.entity.param.teststudent;

import cn.hutool.core.date.DatePattern;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Data
@ApiModel
public class TestStudentQueryParam {

    @ApiModelProperty(value = "学生名称 ", example = "")
    private String studentName;

    @ApiModelProperty(value = "年龄 ", example = "")
    private Integer studentAge;

    @ApiModelProperty(value = "爱好（0代码 1音乐 2电影） ", example = "")
    private String studentHobby;

    @ApiModelProperty(value = "性别（0男 1女 2未知） 字典:sys_user_sex", example = "")
    private String studentSex;

    @ApiModelProperty(value = "状态（0正常 1停用） 字典:sys_normal_disable", example = "")
    private String studentStatus;

    @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日", example = "2023-01-01")
    private Date studentBirthday;

    @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "创建时间开始时间", example = "2023-01-01")
    private Date beginCreateTime;

    @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "创建时间结束时间", example = "2023-01-01")
    private Date endCreateTime;

}