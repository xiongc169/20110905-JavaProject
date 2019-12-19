package org.practice.netty.book01.ch0701serial;

import lombok.Data;

import java.io.Serializable;

@Data
public class SubscribeReq implements Serializable {
    private static final long serialVersionUID = 1L;
    private int subReqID;
    private String userName;
    private String productName;
    private String phoneNumber;
}
