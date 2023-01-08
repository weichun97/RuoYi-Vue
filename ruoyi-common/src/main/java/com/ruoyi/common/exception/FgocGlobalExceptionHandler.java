package com.ruoyi.common.exception;

import cn.hutool.core.util.StrUtil;
import com.ruoyi.common.api.Response;
import com.ruoyi.common.api.ResultCode;
import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.domain.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * @author cocoyang
 * @date 2020/8/13
 * @description 全局异常处理
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class FgocGlobalExceptionHandler {

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public Response handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request)
    {
        return Response.failed(ResultCode.FORBIDDEN);
    }

    @ExceptionHandler(value = ApiException.class)
    public Response handle(ApiException e) {
        if (e.getErrorCode() != null) {
            if(StrUtil.isNotBlank(e.getMsg())){
                log.info(e.getMsg(), e);
                return Response.failed(e.getErrorCode(), e.getMsg());
            }
            return Response.failed(e.getErrorCode());
        }
        log.info(e.getMessage(), e);
        return Response.failed(e.getMessage());
    }

    @ExceptionHandler(value = BindException.class)
    public Response validExceptionHandler(BindException e) {
        log.info(e.getMessage(), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        return Response.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public Response constraintViolationExceptionHandler(ConstraintViolationException e) {
        log.info(e.getMessage(), e);
        return Response.failed(ResultCode.VALIDATE_FAILED, e.getConstraintViolations().iterator().next().getMessage());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Response methodArgumentNotValidHandler(MethodArgumentNotValidException e) {
        log.info(e.getMessage(), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        return Response.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
    }

    @ExceptionHandler(value = {DuplicateKeyException.class})
    public Response handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return Response.failed(ResultCode.DUPLICATE_KEY);
    }

    @ExceptionHandler(value = {Exception.class})
    public Response handle(Exception e) {
        log.error(e.getMessage(), e);
        return Response.failed(ResultCode.FAILED);
    }

}
