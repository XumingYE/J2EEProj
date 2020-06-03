package com.Ka1.dao.Impl;

import com.Ka1.bean.Resuser;
import com.Ka1.dao.ResuserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * ClassName ResuserDaoImpl
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
@Repository
public class ResuserDaoImpl implements ResuserDao {

    private JdbcTemplate jdbcTemplate; // jdbc模板

    @Autowired // spring在运行期自动地将 Datasource注入,装配
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    //自己的版本
    /*@Override
    public Resuser login(Resuser user) {
        String sql = "select * from resuser where username = ? and pwd = ?";// where username = ? and pwd = ?
        RowMapper<Resuser> rowMapper=new BeanPropertyRowMapper<>(Resuser.class);
        return jdbcTemplate.query(sql,rowMapper,user.getUsername(),user.getPwd()).get(0);//,user.getUserid(),user.getPwd()
    }*/

    @Override
    public Resuser login(Resuser user) {
        return this.jdbcTemplate.queryForObject(
                "select * from resuser where username=? and pwd=?",
                //lambda表达式: lambda ->  jvm 底层  编译原理.
                (resultSet, rowNum) -> {
                    Resuser a = new Resuser();
                    a.setUserid(    resultSet.getInt(1)  );
                    a.setUsername(   resultSet.getString(2));
                    a.setPwd(   resultSet.getString(3));
                    a.setEmail(resultSet.getString(4));
                    return a;
                },
                user.getUsername(),  user.getPwd() );
    }
}
