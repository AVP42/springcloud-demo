package com.example.eurekaconsumerfeign.feignClient;
/**
 * COPYRIGHT. Qiyiguo Inc. ALL RIGHTS RESERVED.
 * Project: qudianwan
 * Author: wufuchang <17302023193@163.com>
 * Create On: 2018/07/05
 * Modify On: 2018/07/05 20:30 by wufuchang
 */

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@FeignClient("eureka-client") //定义feign客户端 服务名为eureka-client
public interface DcClient {
    @GetMapping("/dc") //绑定eureka-client服务的/dc接口
    String consumer();
}
