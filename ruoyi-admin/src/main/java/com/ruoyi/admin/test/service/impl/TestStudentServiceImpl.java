package com.ruoyi.admin.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.api.ResultCode;
import com.ruoyi.common.exception.FgocAssert;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.admin.test.entity.dao.TestStudentDao;
import com.ruoyi.admin.test.entity.maps.TestStudentMaps;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentQueryParam;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentSaveOrUpdateParam;
import com.ruoyi.admin.test.entity.po.TestStudentEntity;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentDetailVO;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentQueryVO;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentExportVO;
import com.ruoyi.admin.test.service.TestStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class TestStudentServiceImpl extends ServiceImpl<TestStudentDao, TestStudentEntity> implements TestStudentService {

    @Resource
    private TestStudentMaps testStudentMaps;

    @Override
    public FgocPage<TestStudentQueryVO> query(PageParam pageParam, TestStudentQueryParam queryParam) {
        return baseMapper.query(FgocPage.getPage(pageParam), queryParam);
    }

    @Override
    public void save(TestStudentSaveOrUpdateParam saveOrUpdateParam) {
        save(testStudentMaps.saveOrUpdateParamToPo(saveOrUpdateParam));
    }

    @Override
    public void update(Long id, TestStudentSaveOrUpdateParam saveOrUpdateParam) {
        update(testStudentMaps.saveOrUpdateParamToPo(saveOrUpdateParam),
                new LambdaQueryWrapper<TestStudentEntity>().eq(TestStudentEntity::getId, id));
    }

    @Override
    public void remove(Long[] ids) {
        removeByIds(Arrays.asList(ids));
    }

    @Override
    public TestStudentDetailVO detail(Long id) {
        TestStudentEntity testStudentEntity = getById(id);
        FgocAssert.assertNotNull(testStudentEntity, ResultCode.DATA_DOES_NOT_EXIST);
        return testStudentMaps.poToDetailVo(testStudentEntity);
    }

    @Override
    public void export(HttpServletResponse response, TestStudentQueryParam testStudentQueryParam) {
        List<TestStudentExportVO> list = baseMapper.export(testStudentQueryParam);
        ExcelUtil<TestStudentExportVO> util = new ExcelUtil<>(TestStudentExportVO.class);
        util.exportExcel(response, list, "学生信息表");
    }
}
