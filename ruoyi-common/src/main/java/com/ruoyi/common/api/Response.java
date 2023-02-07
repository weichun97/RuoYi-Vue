package com.ruoyi.common.api;

import com.ruoyi.common.utils.MessageUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author: cocoyang
 * @create: 2020-08-03 14:53
 * @description: 通用返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Response<T> {

    @ApiModelProperty(value = "状态码")
    private long code;


    @ApiModelProperty(value = "响应信息")
    private String message;


    @ApiModelProperty(value = "响应数据")
    private T data;

    /**
     * 成功返回空结果
     */
    public static Response success() {
        return new Response(ResultCode.SUCCESS.getCode(), MessageUtils.message(ResultCode.SUCCESS.getMessage()), null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> Response<T> success(T data) {
        return new Response<T>(ResultCode.SUCCESS.getCode(), MessageUtils.message(ResultCode.SUCCESS.getMessage()), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     * @param params 描述国际化的参数
     */
    public static <T> Response<T> success(T data, String message, Object... params) {
        return new Response<T>(ResultCode.SUCCESS.getCode(), MessageUtils.message(MessageUtils.message(message, params)), data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    public static <T> Response<T> failed(IErrorCode errorCode) {
        return new Response<T>(errorCode.getCode(), MessageUtils.message(errorCode.getMessage()), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param params 描述国际化的参数
     */
    public static <T> Response<T> failed(IErrorCode errorCode, Object... params) {
        return new Response<T>(errorCode.getCode(), MessageUtils.message(errorCode.getMessage(), params), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     * @param params 描述国际化的参数
     */
    public static <T> Response<T> failed(String message, Object... params) {
        return new Response<T>(ResultCode.FAILED.getCode(), MessageUtils.message(message, params), null);
    }

    /**
     * 失败返回结果
     */
    public static <T> Response<T> failed() {
        return failed(ResultCode.FAILED);
    }




}
