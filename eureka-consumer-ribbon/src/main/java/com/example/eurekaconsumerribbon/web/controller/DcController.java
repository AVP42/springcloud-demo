package com.example.eurekaconsumerribbon.web.controller;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/02
 * Modify On: 2018/07/02 17:25 by wufuchang
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@RestController
public class DcController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumerRibbon")
    public String getDc() {
        //这里的eureka-client 就是服务定义的spring.application.name ribbon有一个拦截器，可以拦截到请求，然后自动选取实例，并将实例的ip和端口进行替换，再发出请求
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }
}
