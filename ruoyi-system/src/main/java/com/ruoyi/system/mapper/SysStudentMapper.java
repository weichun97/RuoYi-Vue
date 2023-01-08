package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.system.domain.SysStudent;
import org.apache.ibatis.annotations.Param;

/**
 * 学生信息Mapper接口
 *
 * @author ruoyi
 */
public interface SysStudentMapper extends BaseMapper<SysStudent> {

    FgocPage<SysStudent> queryList(@Param("page") FgocPage page, @Param("sysStudent") SysStudent sysStudent);
}