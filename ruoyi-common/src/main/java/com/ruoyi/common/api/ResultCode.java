package com.ruoyi.common.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author:
 * @create: 2020-08-03 14:53
 * @description: 通用返回信息
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ResultCode implements IErrorCode {

    SUCCESS(200, "successful.operation"),
    FAILED(500, "operation.failure"),
    UNAUTHORIZED(401, "token.expired"),
    VALIDATE_FAILED(402, "customize"),
    FORBIDDEN(403, "forbidden"),
    LOGIN_FAILED(405, "login.failed"),
    LOGIN_CODE_TIMEOUT(405, "login.code.timeout"),
    LOGIN_CODE_FAILED(405, "login.code.failed"),
    DATA_IS_NULL(501, "data.is.null"),
    REMOTE_CALL_FAILED(502, "remote.call.failed"),
    INSERT_ERROR(5000,"insert.error"),
    UPDATE_ERROR(5001,"update.error"),
    DELETE_ERROR(5002,"delete.error"),
    DUPLICATE_KEY(5003,"duplicate.key"),
    DATA_DOES_NOT_EXIST(5004,"data.does.not.exist"),
    REPEAT_SUBMIT(6001,"repeat.submit"),
    ;


//    CODE_20101001(20101001, "航班计划详情获取失败"),
    ;
    private long code;
    private String message;

}
