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

    @Excel(name = "编号")
    private Long id;

    @Excel(name = "学生名称")
    private String studentName;

    @Excel(name = "年龄")
    private Integer studentAge;

    @Excel(name = "爱好", readConverterExp = "0=代码,1=音乐,2=电影")
    private Integer studentHobby;

    @Excel(name = "性别", dictType = "sys_user_sex")
    private Integer studentSex;

    @Excel(name = "状态", dictType = "sys_normal_disable")
    private Integer studentStatus;

    @Excel(name = "生日", width = 30, dateFormat = DatePattern.NORM_DATE_PATTERN)
    private Date studentBirthday;

    @Excel(name = "创建时间", width = 30, dateFormat = DatePattern.NORM_DATETIME_PATTERN)
    private Date createTime;

    @Excel(name = "更新时间", width = 30, dateFormat = DatePattern.NORM_DATE_PATTERN)
    private Date updateTime;

    @Excel(name = "删除时间", width = 30, dateFormat = DatePattern.NORM_DATE_PATTERN)
    private Date deleteTime;

    @Excel(name = "创建人")
    private String createBy;

    @Excel(name = "更新人")
    private String updateBy;

}
