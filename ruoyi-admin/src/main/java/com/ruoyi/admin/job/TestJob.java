package com.ruoyi.admin.job;

import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.stereotype.Component;

@Component
public class TestJob {

    /**
     * 测试定时器
     */
    @XxlJob("test")
    public void test(){
        XxlJobHelper.log("请求参数是:{}", XxlJobHelper.getJobParam());
    }
}
