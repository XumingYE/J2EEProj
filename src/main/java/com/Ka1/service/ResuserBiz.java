package com.Ka1.service;

import com.Ka1.bean.Resuser;

public interface ResuserBiz {
	/*
	 * 登录:  密码md5加密.
	 */
	public Resuser login(Resuser user);
}