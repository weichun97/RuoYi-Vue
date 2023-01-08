package com.ruoyi.web.test.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.web.test.entity.param.student.StudentQueryParam;
import com.ruoyi.web.test.entity.po.StudentEntity;
import com.ruoyi.web.test.entity.vo.student.StudentQueryVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {

    /**
     * 分页
     */
    FgocPage<StudentQueryVO> query(FgocPage<StudentQueryVO> fgocPage, @Param("queryParam") StudentQueryParam queryParam);

    /**
     * 导出查询
     */
    List<StudentQueryVO> query(@Param("queryParam") StudentQueryParam queryParam);
}