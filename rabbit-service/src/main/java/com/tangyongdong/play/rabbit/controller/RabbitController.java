package com.tangyongdong.play.rabbit.controller;

import com.tangyongdong.base.common.response.CommonResponse;
import com.tangyongdong.play.rabbit.api.RabbitApi;
import com.tangyongdong.play.rabbit.service.RabbitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangyongdong
 * @create 2018-05-10 10:34
 */
@RestController
public class RabbitController implements RabbitApi {

    @Autowired
    private RabbitService rabbitService;

    @Override
    public CommonResponse<Boolean> helloWorld() {
        return CommonResponse.success(rabbitService.helloWorld());
    }

    @Override
    public CommonResponse<Boolean> workQueue() {
        return CommonResponse.success(rabbitService.workQueue());
    }

    @Override
    public CommonResponse<Boolean> entityTransport() {
        return CommonResponse.success(rabbitService.entityTransport());
    }

    @Override
    public CommonResponse<Boolean> fanoutExchange() {
        return CommonResponse.success(rabbitService.fanoutExchange());
    }

    @Override
    public CommonResponse<Boolean> topicExchange() {
        return CommonResponse.success(rabbitService.topicExchange());
    }
}
