package com.tangyongdong.play.rabbit.annotation;

import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author tangyongdong
 * @create 2018-05-08 13:15
 */
@EnableFeignClients({"com.tangyongdong.play.rabbit.api"})
public class FeignClientConfiguration {
}
