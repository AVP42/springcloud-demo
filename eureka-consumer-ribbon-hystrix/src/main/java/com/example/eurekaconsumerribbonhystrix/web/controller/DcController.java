package com.example.eurekaconsumerribbonhystrix.web.controller;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/02
 * Modify On: 2018/07/02 17:25 by wufuchang
 */

import com.example.eurekaconsumerribbonhystrix.service.ConsumerService;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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
    ConsumerService consumerService;

    @GetMapping("/consumerRibbonWithHystrix")
    public String getDc() {
        return consumerService.consumer();
    }
}
