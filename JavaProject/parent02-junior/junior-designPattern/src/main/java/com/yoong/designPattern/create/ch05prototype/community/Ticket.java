package com.yoong.designPattern.create.ch05prototype.community;

import lombok.Data;

import java.io.Serializable;

@Data
public class Ticket implements Serializable {
    private static final long serialVersionUID = 3874557314729031623L;
    private Integer id = 10;
    private String name = "name";
    private int cost = 20;
}
