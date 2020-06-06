package com.Ka1.web.entity;

import java.io.Serializable;

public class JsonModel implements Serializable {
	private Integer code; // 1: 操作成功 0:操作失败
	private String msg; // 如果 code=0, 则msg中是错误信息
	private Object obj; // 存数据
	private String url; // 重定向的地址

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
