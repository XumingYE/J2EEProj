package com.Ka1.service.Impl;

import com.Ka1.bean.Resfood;
import com.Ka1.dao.ResfoodDao;
import com.Ka1.service.ResfoodBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResfoodBizImpl implements ResfoodBiz {
	
	@Autowired
	private ResfoodDao resfoodDao;

	@Override
	public List<Resfood> findAll() {
		return resfoodDao.findAllFood();
	}

}