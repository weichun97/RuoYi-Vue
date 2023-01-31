package com.ruoyi.admin.test.entity.vo.teststudent;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class TestStudentDetailVO {

    @ApiModelProperty(value = "编号", example = "1")
    private Long id;

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

    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日", example = "2023-01-01")
    private Date studentBirthday;

}
