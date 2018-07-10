package com.example.eurekaconsumerribbonhystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix //包含了@EnableCircuitBreaker
//或者使用@SpringCloudApplication 包含了上面3个注解
public class EurekaConsumerRibbonHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate redisTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerRibbonHystrixApplication.class, args);
	}
}
