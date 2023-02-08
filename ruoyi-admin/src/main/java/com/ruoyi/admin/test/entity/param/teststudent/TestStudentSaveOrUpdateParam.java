package com.ruoyi.admin.test.entity.param.teststudent;

import cn.hutool.core.date.DatePattern;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@ApiModel
public class TestStudentSaveOrUpdateParam {

    @NotBlank(message = "学生名称{not.null}")
    @ApiModelProperty(value = "学生名称 ", example = "", required = true)
    private String studentName;

    @ApiModelProperty(value = "年龄 ", example = "")
    private Integer studentAge;

    @ApiModelProperty(value = "爱好（0代码 1音乐 2电影） ", example = "")
    private Integer studentHobby;

    @NotNull(message = "性别{not.null}")
    @ApiModelProperty(value = "性别（0男 1女 2未知） 字典:sys_user_sex", example = "", required = true)
    private Integer studentSex;

    @NotNull(message = "状态{not.null}")
    @ApiModelProperty(value = "状态（0正常 1停用） 字典:sys_normal_disable", example = "", required = true)
    private Integer studentStatus;

    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日", example = "2023-01-01")
    private Date studentBirthday;

}
