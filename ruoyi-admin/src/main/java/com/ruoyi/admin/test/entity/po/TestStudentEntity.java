package com.ruoyi.admin.test.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@TableName("test_student")
@NoArgsConstructor
@AllArgsConstructor
public class TestStudentEntity {

    /**
     * 编号
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 学生名称
     */
    @TableField(value = "student_name")
    private String studentName;

    /**
     * 年龄
     */
    @TableField(value = "student_age")
    private Integer studentAge;

    /**
     * 爱好（0代码 1音乐 2电影）
     */
    @TableField(value = "student_hobby")
    private Integer studentHobby;

    /**
     * 性别（0男 1女 2未知）
     */
    @TableField(value = "student_sex")
    private Integer studentSex;

    /**
     * 状态（0正常 1停用）
     */
    @TableField(value = "student_status")
    private Integer studentStatus;

    /**
     * 生日
     */
    @TableField(value = "student_birthday")
    private Date studentBirthday;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 删除时间
     */
    @TableField(value = "delete_time")
    @TableLogic(value = "null", delval = "now()")
    private Date deleteTime;

    /**
     * 创建人
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 更新人
     */
    @TableField(value = "update_by", fill = FieldFill.UPDATE)
    private String updateBy;

}
