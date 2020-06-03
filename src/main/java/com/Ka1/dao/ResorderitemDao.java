package com.Ka1.dao;

import com.Ka1.bean.Resorderitem;

public interface ResorderitemDao {
	
	/**
	 * 订单详情添加到数据库 
	 * @param item
	 */
	void insertResorderitem(  Resorderitem item);
}