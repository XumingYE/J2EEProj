package com.Ka1.service;

import com.Ka1.bean.Resorder;
import com.Ka1.web.entity.CartItem;

import java.util.Map;

public interface ResorderBiz {
	
	/**
	 *  下订
	 * @param resorder: 订单信息
	 * @param shopCart:  购物车，对应订单项
	 *   Map<Integer, CartItem>    Integer:菜的编号
	 *                             CartItem:  num数量    菜的信息
	 */
	public void  completeOrder(Resorder resorder, Map<Integer, CartItem> shopCart  ) ;
}