package org.practice.netty.book01.ch0701serial;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubscribeResp implements Serializable {
    private static final long serialVersionUID = 1l;
    private int subRepID;
    private int respCode;
}
