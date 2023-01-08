package com.ruoyi.web.test.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@TableName("sys_student")
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {
  
    /**
   	 * 编号
   	 */
    @TableId(type = IdType.AUTO)
  	private Integer studentId;
  
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
  	private String studentHobby;
  
    /**
   	 * 性别（0男 1女 2未知）
   	 */
    @TableField(value = "student_sex") 
  	private String studentSex;
  
    /**
   	 * 状态（0正常 1停用）
   	 */
    @TableField(value = "student_status") 
  	private String studentStatus;
  
    /**
   	 * 生日
   	 */
    @TableField(value = "student_birthday") 
  	private Date studentBirthday;
  
}
