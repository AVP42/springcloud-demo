package com.example.eurekaclient.web.controller;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/02
 * Modify On: 2018/07/02 16:46 by wufuchang
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class DcController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String getDc() {
        //模拟服务故障，验证服务降级功能 服务消费方触发了服务请求超时异常，服务消费者就通过HystrixCommand注解中指定的降级逻辑进行执行
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String services = "services:"+discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
