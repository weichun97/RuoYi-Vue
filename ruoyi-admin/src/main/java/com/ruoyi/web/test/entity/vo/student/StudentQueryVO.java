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


    @ApiModelProperty(value = "编号", example = "")
  	private Integer studentId;

    @Excel(name = "学生名称")
    @ApiModelProperty(value = "学生名称", example = "")
  	private String studentName;

    @Excel(name = "年龄")
    @ApiModelProperty(value = "年龄", example = "")
  	private Integer studentAge;

    @Excel(name = "爱好")
    @ApiModelProperty(value = "爱好（0代码 1音乐 2电影）", example = "")
  	private String studentHobby;

    @Excel(name = "性别", dictType = "sys_user_sex")
    @ApiModelProperty(value = "性别（0男 1女 2未知）", example = "")
  	private String studentSex;

    @Excel(name = "状态")
    @ApiModelProperty(value = "状态（0正常 1停用）", example = "")
  	private String studentStatus;

    @Excel(name = "生日", dateFormat = DatePattern.NORM_DATE_PATTERN)
    @JsonFormat(pattern = DatePattern.NORM_DATE_PATTERN)
    @ApiModelProperty(value = "生日", example = "")
  	private Date studentBirthday;
  
}
