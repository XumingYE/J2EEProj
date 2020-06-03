package com.Ka1.service.Impl;

import com.Ka1.bean.Resorder;
import com.Ka1.bean.Resorderitem;
import com.Ka1.dao.ResorderDao;
import com.Ka1.dao.ResorderitemDao;
import com.Ka1.service.ResorderBiz;
import com.Ka1.web.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class ResorderBizImpl implements ResorderBiz {
	@Autowired
	private ResorderDao resorderDao;
	@Autowired
	private ResorderitemDao resorderitemDao;

	/*
	 * 1个订单+n个订单项
	 * 事务
	 */
	@Override  
	@Transactional(   rollbackFor=RuntimeException.class )
	public void completeOrder(Resorder resorder, Map<Integer, CartItem> shopCart) {
			//1. 插入订单
		   Resorder orderResult=resorderDao.insertResorder(   resorder );
		   //新订单的编号
		   int oid=orderResult.getRoid();
		   if(   shopCart!=null&&shopCart.size()>0) {
			   
			   for( Map.Entry<Integer, CartItem> entry: shopCart.entrySet() ) {
				   Resorderitem ri=new Resorderitem();
				   ri.setRoid(   oid );
				   ri.setNum(   entry.getValue().getNum()   );   // 数量
				   ri.setFid(   entry.getKey() );
				   ri.setDealprice(   entry.getValue().getFood().getRealprice()   );
				   resorderitemDao.insertResorderitem( ri );
				  
				   //throw new RuntimeException("添加订单详情出问题了，网络抖动...");
				   
			   }
		   }
	}

}