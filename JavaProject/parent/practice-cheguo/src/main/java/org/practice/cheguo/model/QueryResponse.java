package org.practice.cheguo.model;

public class QueryResponse {

	private String code;

	private String msg;

	private QueryData data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public QueryData getData() {
		return data;
	}

	public void setData(QueryData data) {
		this.data = data;
	}
}
