package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysStudent;
import com.ruoyi.system.mapper.SysStudentMapper;
import com.ruoyi.system.service.ISysStudentService;

/**
 * 学生信息Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class SysStudentServiceImpl extends ServiceImpl<SysStudentMapper, SysStudent> implements ISysStudentService
{
    @Override
    public FgocPage<SysStudent> queryList(PageParam pageParam, SysStudent sysStudent)
    {
        return baseMapper.queryList(FgocPage.getPage(pageParam), sysStudent);
    }
}