package com.ruoyi.web.test.entity.param.student;

import cn.hutool.core.date.DatePattern;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel
public class StudentQueryParam {

    @ApiModelProperty(value = "学生名称", example = "")
  	private String studentName;

    @ApiModelProperty(value = "学生性别", example = "")
    private Integer studentSex;

    @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日开始时间", example = "")
    private Date beginStudentBirthday;

    @DateTimeFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日结束时间", example = "")
    private Date endStudentBirthday;
}