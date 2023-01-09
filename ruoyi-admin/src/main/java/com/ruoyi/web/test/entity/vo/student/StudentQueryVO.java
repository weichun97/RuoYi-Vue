package com.ruoyi.web.test.entity.vo.student;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class StudentQueryVO {

    @ApiModelProperty(value = "编号 ", example = "")
    private Long studentId;

    @ApiModelProperty(value = "学生名称 ", example = "")
    @Excel(name = "学生名称")
    private String studentName;

    @ApiModelProperty(value = "年龄 ", example = "")
    @Excel(name = "年龄")
    private Integer studentAge;

    @ApiModelProperty(value = "爱好（0代码 1音乐 2电影） ", example = "")
    @Excel(name = "爱好", readConverterExp = "0=代码,1=音乐,2=电影")
    private String studentHobby;

    @ApiModelProperty(value = "性别（0男 1女 2未知） 字典:sys_user_sex", example = "")
    @Excel(name = "性别", dictType = "sys_user_sex")
    private String studentSex;

    @ApiModelProperty(value = "状态（0正常 1停用） 字典:sys_normal_disable", example = "")
    @Excel(name = "状态", dictType = "sys_normal_disable")
    private String studentStatus;

    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日", example = "2023-01-01")
    @Excel(name = "生日")
    private Date studentBirthday;

    @JsonFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    @ApiModelProperty(value = "创建时间", example = "2023-01-01 12:00:00")
    @Excel(name = "创建时间")
    private Date createTime;

}
