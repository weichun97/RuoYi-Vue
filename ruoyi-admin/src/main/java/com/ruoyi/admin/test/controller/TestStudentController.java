package com.ruoyi.admin.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.api.Response;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentQueryParam;
import com.ruoyi.admin.test.entity.param.teststudent.TestStudentSaveOrUpdateParam;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentDetailVO;
import com.ruoyi.admin.test.entity.vo.teststudent.TestStudentQueryVO;
import com.ruoyi.admin.test.service.TestStudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(value = "TestStudentController", tags = "学生信息")
@RequestMapping("test/testStudent")
@RestController
public class TestStudentController {

    @Resource
    private TestStudentService testStudentService;

    @ApiOperation("分页")
    @PreAuthorize("@ss.hasPermi('test:testStudent:query')")
    @GetMapping("query")
    public Response<FgocPage<TestStudentQueryVO>> query(PageParam pageParam, TestStudentQueryParam testStudentQueryParam) {
        return Response.success(testStudentService.query(pageParam, testStudentQueryParam));
    }

    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('test:testStudent:export')")
    @Log(title = "test.testStudent", businessType = BusinessType.EXPORT)
    @PostMapping("export")
    public void export(HttpServletResponse response, TestStudentQueryParam testStudentQueryParam)
    {
        testStudentService.export(response, testStudentQueryParam);
    }

    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('test:testStudent:detail')")
    @GetMapping("{id}")
    public Response<TestStudentDetailVO> detail(@PathVariable Long id){
        return Response.success(testStudentService.detail(id));
    }

    @ApiOperation("保存")
    @PreAuthorize("@ss.hasPermi('test:testStudent:save')")
    @Log(title = "test.testStudent", businessType = BusinessType.INSERT)
    @PostMapping
    public Response save(@Valid @RequestBody TestStudentSaveOrUpdateParam saveOrUpdateParam){
        testStudentService.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新")
    @PreAuthorize("@ss.hasPermi('test:testStudent:update')")
    @Log(title = "test.testStudent", businessType = BusinessType.UPDATE)
    @PutMapping("{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody TestStudentSaveOrUpdateParam saveOrUpdateParam){
        testStudentService.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('test:testStudent:remove')")
    @Log(title = "test.testStudent", businessType = BusinessType.DELETE)
    @DeleteMapping("{ids}")
    public Response remove(@PathVariable Long[] ids){
        testStudentService.remove(ids);
        return Response.success();
    }
}