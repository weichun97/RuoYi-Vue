package com.ruoyi.web.test.entity.vo.student;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class StudentDetailVO {

    @ApiModelProperty(value = "编号", example = "")
    private Integer studentId;

    @ApiModelProperty(value = "学生名称", example = "")
    private String studentName;

    @ApiModelProperty(value = "年龄", example = "")
    private Integer studentAge;

    @ApiModelProperty(value = "爱好（0代码 1音乐 2电影）", example = "")
    private String studentHobby;

    @ApiModelProperty(value = "性别（0男 1女 2未知）", example = "")
    private String studentSex;

    @ApiModelProperty(value = "状态（0正常 1停用）", example = "")
    private String studentStatus;

    @ApiModelProperty(value = "生日", example = "")
    private Date studentBirthday;
}
