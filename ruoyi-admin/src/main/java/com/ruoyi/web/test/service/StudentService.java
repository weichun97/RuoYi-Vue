package com.ruoyi.web.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import com.ruoyi.web.test.entity.param.student.StudentQueryParam;
import com.ruoyi.web.test.entity.param.student.StudentSaveOrUpdateParam;
import com.ruoyi.web.test.entity.po.StudentEntity;
import com.ruoyi.web.test.entity.vo.student.StudentDetailVO;
import com.ruoyi.web.test.entity.vo.student.StudentQueryVO;

import javax.servlet.http.HttpServletResponse;

public interface StudentService extends IService<StudentEntity> {

    /**
     * 学生信息表分页

     * @param pageParam
     * @param queryParam
     * @return
     */
    FgocPage<StudentQueryVO> query(PageParam pageParam, StudentQueryParam queryParam);

    /**
     * 保存学生信息表
     * @param saveOrUpdateParam
     */
    void save(StudentSaveOrUpdateParam saveOrUpdateParam);

    /**
     * 更新学生信息表
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, StudentSaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除学生信息表
     * @param ids
     */
    void remove(Long[] ids);

    /**
     * 详情
     * @param id
     */
    StudentDetailVO detail(Long id);

    /**
     * 导出
     * @param response
     * @param studentQueryParam
     */
    void export(HttpServletResponse response, StudentQueryParam studentQueryParam);
}
