package com.ruoyi.web.test.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.api.Response;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.mybatis.FgocPage;
import com.ruoyi.common.mybatis.PageParam;
import com.ruoyi.web.test.entity.param.student.StudentQueryParam;
import com.ruoyi.web.test.entity.param.student.StudentSaveOrUpdateParam;
import com.ruoyi.web.test.entity.vo.student.StudentDetailVO;
import com.ruoyi.web.test.entity.vo.student.StudentQueryVO;
import com.ruoyi.web.test.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Api(value = "StudentController", tags = "学生信息")
@RequestMapping("test/student")
@RestController
public class StudentController {

    @Resource
    private StudentService studentService;

    @ApiOperation("分页")
    @PreAuthorize("@ss.hasPermi('test:student:query')")
    @GetMapping("query")
    public Response<FgocPage<StudentQueryVO>> query(PageParam pageParam, StudentQueryParam studentQueryParam) {
        return Response.success(studentService.query(pageParam, studentQueryParam));
    }

    @ApiOperation("导出")
    @PreAuthorize("@ss.hasPermi('test:student:export')")
    @Log(title = "学生信息", businessType = BusinessType.EXPORT)
    @PostMapping("export")
    public void export(HttpServletResponse response, StudentQueryParam studentQueryParam)
    {
        studentService.export(response, studentQueryParam);
    }

    @ApiOperation("详情")
    @PreAuthorize("@ss.hasPermi('test:student:detail')")
    @GetMapping("{id}")
    public Response<StudentDetailVO> detail(@PathVariable Long id){
        return Response.success(studentService.detail(id));
    }

    @ApiOperation("保存")
    @PreAuthorize("@ss.hasPermi('test:student:save')")
    @Log(title = "学生信息", businessType = BusinessType.INSERT)
    @PostMapping
    public Response save(@Valid @RequestBody StudentSaveOrUpdateParam saveOrUpdateParam){
        studentService.save(saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("更新")
    @PreAuthorize("@ss.hasPermi('test:student:update')")
    @Log(title = "学生信息", businessType = BusinessType.UPDATE)
    @PutMapping("{id}")
    public Response update(@PathVariable Long id, @Valid @RequestBody StudentSaveOrUpdateParam saveOrUpdateParam){
        studentService.update(id, saveOrUpdateParam);
        return Response.success();
    }

    @ApiOperation("删除")
    @PreAuthorize("@ss.hasPermi('test:student:remove')")
    @Log(title = "学生信息", businessType = BusinessType.DELETE)
    @DeleteMapping("{ids}")
    public Response remove(@PathVariable Long[] ids){
        studentService.remove(ids);
        return Response.success();
    }
}