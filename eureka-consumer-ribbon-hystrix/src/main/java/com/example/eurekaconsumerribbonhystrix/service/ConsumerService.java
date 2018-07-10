package com.example.eurekaconsumerribbonhystrix.service;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/09
 * Modify On: 2018/07/09 14:57 by wufuchang
 */

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        //这里的eureka-client 就是服务定义的spring.application.name ribbon有一个拦截器，可以拦截到请求，然后自动选取实例，并将实例的ip和端口进行替换，再发出请求
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    /**
     * 服务降级方法，返回值必须和服务方法一致
     */
    public String fallback() {
        return "fallback";
    }
}
