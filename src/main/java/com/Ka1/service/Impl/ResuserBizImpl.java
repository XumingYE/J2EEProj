package com.Ka1.service.Impl;

import com.Ka1.bean.Resuser;
import com.Ka1.dao.ResuserDao;
import com.Ka1.service.ResuserBiz;
import com.Ka1.util.Encrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // spring业务层注解( 异常,事务) , 由spring托管这个类( new,管理对象 )
public class ResuserBizImpl implements ResuserBiz {
	// 注入Dao类的对象
	@Autowired
	private ResuserDao resuserDao;
	@Override
	public Resuser login(Resuser user) {
		user.setPwd(Encrypt.md5(user.getPwd())); // 业务
		return resuserDao.login(user);
	}
}