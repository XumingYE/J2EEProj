package com.Ka1.dao.Impl;

import com.Ka1.bean.Resorderitem;
import com.Ka1.dao.ResorderitemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * ClassName ResorderitemDaoImpl
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
@Repository
public class ResorderitemDaoImpl implements ResorderitemDao {
    private JdbcTemplate jdbcTemplate; // jdbc模板

    @Autowired // spring在运行期自动地将 Datasource注入,装配
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    @Override
    public void insertResorderitem(Resorderitem item) {

        String sql = "insert into resorderitem (  roid,fid,dealprice,num) values(?,?,?,?)";

        int num = this.jdbcTemplate.update(  sql, item.getRoid(),item.getFid(),item.getDealprice(),item.getNum());
        System.out.println("插入成功,影响" + num + "行");
    }
}
