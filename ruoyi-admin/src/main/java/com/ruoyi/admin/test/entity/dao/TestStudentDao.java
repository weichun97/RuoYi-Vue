package com.ruoyi.admin.test.entity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentQueryParam;
import com.ruoyi.admin.test.entity.po.TestStudentEntity;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentQueryVO;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentExportVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestStudentDao extends BaseMapper<TestStudentEntity> {

    /**
     * 分页
     */
    FgocPage<TestStudentQueryVO> query(FgocPage<TestStudentQueryVO> fgocPage, @Param("queryParam") TestStudentQueryParam queryParam);

    /**
     * 导出查询
     */
    List<TestStudentExportVO> export(@Param("queryParam") TestStudentQueryParam queryParam);
}