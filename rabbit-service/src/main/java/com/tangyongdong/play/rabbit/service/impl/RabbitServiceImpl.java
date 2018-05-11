package com.tangyongdong.play.rabbit.service.impl;

import com.alibaba.fastjson.JSON;
import com.tangyongdong.base.api.IdWorkerApi;
import com.tangyongdong.play.rabbit.config.RabbitConfig;
import com.tangyongdong.play.rabbit.dto.EntityDTO;
import com.tangyongdong.play.rabbit.service.RabbitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author tangyongdong
 * @create 2018-05-10 10:35
 */
@Service
@Slf4j
public class RabbitServiceImpl implements RabbitService {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    private IdWorkerApi idWorkerApi;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public Boolean helloWorld() {
        String id = idWorkerApi.getId().getData();
        log.info("=============== rabbit helloWorld send start:{}", id);
        rabbitTemplate.convertAndSend(RabbitConfig.RABBIT_HELLO, id);
        log.info("=============== rabbit helloWorld send end");
        return Boolean.TRUE;
    }

    @Override
    public Boolean workQueue() {
        String id = idWorkerApi.getId().getData();
        log.info("=============== rabbit workQueue send start:{}", id);
        rabbitTemplate.convertAndSend(RabbitConfig.RABBIT_WORK, id);
        log.info("=============== rabbit workQueue send end");
        return Boolean.TRUE;
    }

    @Override
    public Boolean entityTransport() {
        EntityDTO entityDTO = EntityDTO.builder()
                .id(idWorkerApi.getId().getData())
                .name(applicationName)
                .build();
        log.info("=============== rabbit entityTransport send start:{}", JSON.toJSONString(entityDTO));
        rabbitTemplate.convertAndSend(RabbitConfig.RABBIT_ENTITY, entityDTO);
        log.info("=============== rabbit entityTransport send end");
        return Boolean.TRUE;
    }

    @Override
    public Boolean fanoutExchange() {
        String id = idWorkerApi.getId().getData();
        log.info("=============== rabbit fanoutExchange send start:{}", id);
        rabbitTemplate.convertAndSend(RabbitConfig.FANOUT_EXCHANGE, "", id);
        log.info("=============== rabbit fanoutExchange send end");
        return Boolean.TRUE;
    }

    @Override
    public Boolean topicExchange() {
        String id = idWorkerApi.getId().getData();
        log.info("=============== rabbit topicExchange send start:{}", id);
        try {
            rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.RABBIT_RED_TOPIC_A, id.concat("-1"));
            Thread.sleep(200);
            rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.RABBIT_RED_TOPIC_B, id.concat("-2"));
            Thread.sleep(200);
            rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, RabbitConfig.RABBIT_BLUE_TOPIC_A, id.concat("-3"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("=============== rabbit topicExchange send end");
        return Boolean.TRUE;
    }
}
