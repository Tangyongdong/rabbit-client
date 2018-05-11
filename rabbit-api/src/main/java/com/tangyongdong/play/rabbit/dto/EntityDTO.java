package com.tangyongdong.play.rabbit.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author tangyongdong
 * @create 2018-05-11 10:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityDTO implements Serializable{
    private String id;
    private String name;

}
