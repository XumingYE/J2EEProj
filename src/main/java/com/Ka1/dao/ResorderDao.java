package com.Ka1.dao;

import com.Ka1.bean.Resorder;

public interface ResorderDao {
	
	/**
	 * 将  resorder对象中的数据添加到   resorder表中,  
	 * 请注意;   添加成功后，要在  返回的Resorder 中加入   自动生成的订单编号.
	 * spring jdbctemplate   返回自增列
	 * @param resorder
	 * @return
	 */
	 Resorder insertResorder(Resorder resorder);
}