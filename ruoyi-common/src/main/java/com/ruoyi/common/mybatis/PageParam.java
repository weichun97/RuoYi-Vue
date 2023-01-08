package com.ruoyi.common.mybatis;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@ApiModel
public class PageParam {

    @NotNull(message = "显示条数不能为空")
    @ApiModelProperty(value = "每页显示条数", example = "10", required = true)
    private long pageSize = 10;

    @NotNull(message = "当前页不能为空")
    @ApiModelProperty(value = "当前页", example = "1", required = true)
    private long pageNum = 1;
}
