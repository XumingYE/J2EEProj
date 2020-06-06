package com.Ka1.web.controller;

import com.Ka1.bean.Resfood;
import com.Ka1.service.ResfoodBiz;
import com.Ka1.web.entity.CartItem;
import com.Ka1.web.entity.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController    // 1. 这是控制层   2. Rest规范(   支持 GET/POST/DELETE/PUT,   回送数据格式  json)
public class ResfoodController {

	@Autowired
	private ResfoodBiz resfoodBiz;


	@RequestMapping("/clear")
	public JsonModel clear( HttpSession session, JsonModel jm   ) {
		if(session.getAttribute("cart")!=null  ) {
			session.removeAttribute("cart");
		}
		jm.setCode(1);
		return jm;
	}

	@RequestMapping("/getCartInfo")
	public JsonModel getCartInfo( HttpSession session, JsonModel jm   ) {
		Map<Integer,CartItem>   cart=null;
		if(session.getAttribute("cart")==null  ) {
			jm.setCode(0);
			jm.setMsg("购物车为空");
			return jm;
		}
		cart=(Map<Integer, CartItem>)session.getAttribute("cart");
		jm.setCode(1);
		jm.setObj(cart);
		return jm;
	}


	@RequestMapping("/order")
	public JsonModel order( HttpSession session, Integer fid, Integer num, JsonModel jm   ) {
		//1. 取出所有的菜  ( ServletContext-> application )
		ServletContext application=session.getServletContext();
		List<Resfood> list=null;
		if(   application.getAttribute("list")!=null) {
			list=(List<Resfood>)application.getAttribute("list");
		}else {
			list=resfoodBiz.findAll();
		}
		Resfood toBuy=null;
		//2. 根据fid到上面找这道菜
		for( Resfood rf:list) {
			if(  rf.getFid()==   fid   ) {
				toBuy=rf;
				break;
			}
		}
		//3. 如果没有，则返回 code=0
		if(   toBuy==null) {
			jm.setCode(0);
			jm.setMsg("查无此道菜....");
			return jm;
		}
		//4. 如果有, 取出  session中的  购物车Map
		Map<Integer,CartItem> cart=new HashMap<Integer, CartItem>();
		//5.   如没有session中没有这个map,创建
		if(  session.getAttribute("cart")!=null) {
			cart=(Map<Integer, CartItem>)session.getAttribute("cart");
		}
		CartItem ci=null;
		boolean isAdd = true;
		//6. 查这个map中是否有这个  fid
		if(cart.containsKey(fid)) {
			//7. 有，则加数量
			ci=cart.get(fid);
			if(ci.getNum()+num ==0){
				cart.remove(fid);
				isAdd = false;
			}
			else {
				ci.setNum(     ci.getNum()+num );
			}
		}else {
			//8. 没有，则新建一个CartItem存入
			ci=new CartItem();
			ci.setFood(toBuy);
			ci.setNum(num);
		}
		if(isAdd)
			cart.put(     fid, ci  );
		//9 .将这个Map存到 session中
		session.setAttribute("cart", cart);
		jm.setCode(1);
		//jm.setObj(cart);
		return jm;
	}



	@RequestMapping( "/findFood")
	public JsonModel findFood( HttpSession session, Resfood food, JsonModel jm   ) {
		ServletContext application=session.getServletContext();
		List<Resfood> list=null;
		if(   application.getAttribute("list")!=null) {
			list=(List<Resfood>)application.getAttribute("list");
		}else {
			list=resfoodBiz.findAll();
		}
		for( Resfood rf:list) {
			if(  rf.getFid()==   food.getFid()) {
				jm.setCode(1);
				jm.setObj(rf);
				return jm;
			}
		}
		jm.setCode(0);
		jm.setMsg("查无此商品");
		return jm;
	}


	@RequestMapping( value="/findAllFoods",method= {RequestMethod.GET,RequestMethod.POST} )
	public JsonModel findAllFoods( HttpSession session,  JsonModel jm   ) {   //  spring   IOC/DI
		ServletContext application=session.getServletContext();
		List<Resfood> list=null;
		if(   application.getAttribute("list")!=null) {
			list=(List<Resfood>)application.getAttribute("list");
		}else {
			list=resfoodBiz.findAll();
		}
		jm.setCode(1);
		jm.setObj(list);
		application.setAttribute("list", list);
		return jm;
	}
}
