package com.Ka1.dao;

import com.Ka1.bean.Resuser;

public interface ResuserDao {
		/*
		 * 登录功能:
		 * select * from resuser where username=? and password=?
		 */
		Resuser login(Resuser user);
}