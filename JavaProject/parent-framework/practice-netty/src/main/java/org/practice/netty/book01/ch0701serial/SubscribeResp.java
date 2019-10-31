package org.practice.netty.book01.ch0701serial;

import java.io.Serializable;

public class SubscribeResp implements Serializable {

	private static final long serialVersionUID = 1l;

	private int subRepID;

	private int respCode;

	public int getSubRepID() {
		return subRepID;
	}

	public void setSubRepID(int subRepID) {
		this.subRepID = subRepID;
	}

	public int getRespCode() {
		return respCode;
	}

	public void setRespCode(int respCode) {
		this.respCode = respCode;
	}

}
