package com.Ka1.web.controller;

import com.Ka1.bean.Resuser;
import com.Ka1.service.ResuserBiz;
import com.Ka1.web.entity.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class ResuserController {
	@Autowired
	private ResuserBiz resuserBiz;
	
	@RequestMapping( value="checkLogin", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonModel checkLogin(HttpSession session, JsonModel jm) {
		//退出的核心是将session中保存的loginuser删除
		if(   session.getAttribute("loginuser")!=null ) {
			jm.setCode(1);
			jm.setObj(session.getAttribute("loginuser"));
		}else {
			jm.setCode(0);
		}
		return jm;
	}
	@RequestMapping( value="logout", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonModel logout(HttpSession session, JsonModel jm) {
		//退出的核心是将session中保存的loginuser删除
		session.removeAttribute("loginuser");
		jm.setCode(1);
		return jm;
	}
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public JsonModel login(HttpSession session, JsonModel jm, String username, String pwd, String valcode) {
		if(  valcode==null||"".equals(valcode)) {
			jm.setCode(0);
			jm.setMsg("验证码不能为空....");
			return jm;
		}
		//从session中取出标准验证码
		String code=(String)session.getAttribute("validateCode");
		if(   !code.equals(valcode) ) {
			jm.setCode(0);
			jm.setMsg("验证码错误....");
			return jm;
		}
		Resuser u=new Resuser();
		u.setUsername(username);
		u.setPwd(pwd);
		try {
			Resuser user=resuserBiz.login(u);
			if(   user!=null) {
				session.setAttribute("loginuser", user);   //保存登录的状态
				jm.setCode( 1);
			}
		}catch( Exception e) {
			jm.setCode(0);
			jm.setMsg("用户名或密码错误,"+e.getMessage());
		}
		return jm;
	}
	
}