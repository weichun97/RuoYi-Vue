package com.ruoyi.admin.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentQueryParam;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentSaveOrUpdateParam;
import com.ruoyi.admin.test.entity.po.TestStudentEntity;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentDetailVO;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentQueryVO;

import javax.servlet.http.HttpServletResponse;

public interface TestStudentService extends IService<TestStudentEntity> {

    /**
     * 分页
     * @param pageParam
     * @param queryParam
     * @return
     */
    FgocPage<TestStudentQueryVO> query(PageParam pageParam, TestStudentQueryParam queryParam);

    /**
     * 保存
     * @param saveOrUpdateParam
     */
    void save(TestStudentSaveOrUpdateParam saveOrUpdateParam);

    /**
     * 更新
     * @param id
     * @param saveOrUpdateParam
     */
    void update(Long id, TestStudentSaveOrUpdateParam saveOrUpdateParam);

    /**
     * 删除
     * @param ids
     */
    void remove(Long[] ids);

    /**
     * 详情
     * @param id
     */
    TestStudentDetailVO detail(Long id);

    /**
     * 导出
     * @param response
     * @param studentQueryParam
     */
    void export(HttpServletResponse response, TestStudentQueryParam studentQueryParam);
}
