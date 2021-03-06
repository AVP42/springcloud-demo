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
        String services = "services2:"+discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
