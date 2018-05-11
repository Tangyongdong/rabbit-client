package com.tangyongdong.play.rabbit.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author tangyongdong
 * @create 2018-05-08 13:13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Import({FeignClientConfiguration.class})
public @interface RabbitClientStarter {
}
