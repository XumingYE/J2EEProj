package com.Ka1.dao.Impl;

import com.Ka1.bean.Resfood;
import com.Ka1.dao.ResfoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * ClassName ResfoodDaoImpl
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
@Repository // Dao层专用注解 -> spring会自动实例化这个类的对象，保存到spring容器中.
public class ResfoodDaoImpl implements ResfoodDao {


    private JdbcTemplate jdbcTemplate; // jdbc模板

    @Autowired // spring在运行期自动地将 Datasource注入,装配
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    @Override
    public List<Resfood> findAllFood() {
        System.out.print("Ok");
        String sql = "select * from resfood";


        return this.jdbcTemplate.query(sql, (resultSet, rowNum)-> {
            //从resultSet中取一行出来, 包装成一个  Resfood对象
            Resfood rf=new Resfood();
            rf.setFid(    resultSet.getInt( 1 ) );
            rf.setFname(  resultSet.getString(2) );
            rf.setNormprice( resultSet.getDouble(3) );
            rf.setRealprice(  resultSet.getDouble(4));
            rf.setDetail(   resultSet.getString(5));
            rf.setFphoto(   resultSet.getString("fphoto") );
            return rf;
        });

    }
}
