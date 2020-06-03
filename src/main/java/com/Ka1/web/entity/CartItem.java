package com.Ka1.web.entity;

import com.Ka1.bean.Resfood;

import java.io.Serializable;



//一个订单项
public class CartItem implements Serializable {

	private static final long serialVersionUID = 5289673702604344227L;

	//菜的信息
	private Resfood food;
	private int num;   //数量
	private double smallCount;   //小计

	public double getSmallCount() {
		this.smallCount = num * food.getRealprice();
		return smallCount;
	}

	public Resfood getFood() {
		return food;
	}

	public void setFood(Resfood food) {
		this.food = food;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}