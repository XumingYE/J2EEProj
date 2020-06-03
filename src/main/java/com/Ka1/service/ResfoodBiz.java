package com.Ka1.service;

import com.Ka1.bean.Resfood;

import java.util.List;

public interface ResfoodBiz {
	
	/*
	 * 查询所有的菜: 
	 */
	public List<Resfood> findAll();
}