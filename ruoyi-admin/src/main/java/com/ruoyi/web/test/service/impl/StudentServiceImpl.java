package com.ruoyi.web.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.api.ResultCode;
import com.ruoyi.common.exception.FgocAssert;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.test.entity.dao.StudentDao;
import com.ruoyi.web.test.entity.maps.StudentMaps;
import com.ruoyi.web.test.entity.param.student.StudentQueryParam;
import com.ruoyi.web.test.entity.param.student.StudentSaveOrUpdateParam;
import com.ruoyi.web.test.entity.po.StudentEntity;
import com.ruoyi.web.test.entity.vo.student.StudentDetailVO;
import com.ruoyi.web.test.entity.vo.student.StudentQueryVO;
import com.ruoyi.web.test.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, StudentEntity> implements StudentService {

    @Resource
    private StudentMaps studentMaps;

    @Override
    public FgocPage<StudentQueryVO> query(PageParam pageParam, StudentQueryParam queryParam) {
        return baseMapper.query(FgocPage.getPage(pageParam), queryParam);
    }

    @Override
    public void save(StudentSaveOrUpdateParam saveOrUpdateParam) {
        save(studentMaps.saveOrUpdateParamToPo(saveOrUpdateParam));
    }

    @Override
    public void update(Long id, StudentSaveOrUpdateParam saveOrUpdateParam) {
        update(studentMaps.saveOrUpdateParamToPo(saveOrUpdateParam),
                new LambdaQueryWrapper<StudentEntity>().eq(StudentEntity::getStudentId, id));
    }

    @Override
    public void remove(Long[] ids) {
        removeByIds(Arrays.asList(ids));
    }

    @Override
    public StudentDetailVO detail(Long id) {
        StudentEntity studentEntity = getById(id);
        FgocAssert.assertNotNull(studentEntity, ResultCode.DATA_DOES_NOT_EXIST);
        return studentMaps.poToDetailVo(studentEntity);
    }

    @Override
    public void export(HttpServletResponse response, StudentQueryParam studentQueryParam) {
        List<StudentQueryVO> list = baseMapper.query(studentQueryParam);
        ExcelUtil<StudentQueryVO> util = new ExcelUtil<>(StudentQueryVO.class);
        util.exportExcel(response, list, "学生数据");
    }
}
