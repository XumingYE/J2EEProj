package com.Ka1.web.controller;

import com.Ka1.bean.Resorder;
import com.Ka1.bean.Resorderitem;
import com.Ka1.bean.Resuser;
import com.Ka1.service.ResorderBiz;
import com.Ka1.web.entity.CartItem;
import com.Ka1.web.entity.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * ClassName ResorderController
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/5
 * Version 1.0
 */
@RestController
public class ResorderController {

    @Autowired
    ResorderBiz resorderBiz;

    @RequestMapping( value = "/checkOrder", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel checkOrder(HttpSession session, JsonModel jm ){
        if(session.getAttribute("cart") != null){
            jm.setCode(1);
            jm.setObj(session.getAttribute("cart"));
        }else {
            jm.setCode(0);
        }
        return jm;
    }

    @RequestMapping( value = "/submit", method = {RequestMethod.GET,RequestMethod.POST})
    public JsonModel submit(HttpSession session, JsonModel jm , String address,String tel,String ps){
        //public void completeOrder(Resorder resorder, Map<Integer, CartItem > shopCart) {
        //1.获取session中的item
        Map<Integer,CartItem> cart=null;
        if(session.getAttribute("cart")==null  ) {
            jm.setCode(0);
            jm.setMsg("购物车为空");
            return jm;
        }
        cart=(Map<Integer, CartItem>)session.getAttribute("cart");
        //2.封装成Resorderitem订单项
        //3.封装成Resorder订单  Integer userid;
        //    String address;
        //    String tel;String ps;
        //    Integer status;

        //3.1获取userid
        Resuser resuser = null;
        if(session.getAttribute("loginuser") == null){
            jm.setCode(0);
            jm.setMsg("用户未登录");
            return jm;
        }
        resuser =(Resuser) session.getAttribute("loginuser");
        Integer userid = resuser.getUserid();

        //3.2封装Resorder对象
        Resorder resorder = new Resorder();
        resorder.setUserid(userid);
        resorder.setAddress(address);
        resorder.setTel(tel);
        resorder.setPs(ps);
        resorder.setStatus(1);
        //4.写入到数据库

        resorderBiz.completeOrder(resorder,cart);
        jm.setCode(1);
        jm.setMsg("提交成功");
        return jm;
    }


}
