package com.yoong.junior.book01.chap13;

import lombok.Data;

import java.io.Serializable;

@Data
public class LfuElement implements Serializable {

    private String key;
    private int count;

    public LfuElement(String key, int count) {
        this.key = key;
        this.count = count;
    }
}
