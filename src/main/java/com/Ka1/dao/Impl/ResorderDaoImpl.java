package com.Ka1.dao.Impl;

import com.Ka1.bean.Resorder;
import com.Ka1.dao.ResorderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

/**
 * ClassName ResorderDaoImpl
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */
@Repository
public class ResorderDaoImpl implements ResorderDao {
    private JdbcTemplate jdbcTemplate; // jdbc模板

    @Autowired // spring在运行期自动地将 Datasource注入,装配
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }

    /*@Override
    public Resorder insertResorder(Resorder resorder) {

        String sql = "insert into resorder (userid,address,tel,ordertime,deliverytime,ps,status) values(?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {

            @Override
            public PreparedStatement createPreparedStatement(Connection con)
                    throws SQLException {
                //设置返回的主键字段名
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1,resorder.getUserid());
                ps.setString(2,resorder.getAddress());
                ps.setString(3,resorder.getTel());
                ps.setDate(4,resorder.getOrdertime());
                ps.setDate(5,resorder.getDeliverytime());
                ps.setString(6,resorder.getPs());
                ps.setInt(7,resorder.getStatus());
                return ps;
            }
        }, keyHolder);

        resorder.setRoid(Objects.requireNonNull(keyHolder.getKey()).intValue());

        System.out.println("执行成功，主键" + resorder.getRoid());
        return resorder;
    }*/
    @Override
    public Resorder insertResorder(Resorder resorder) {
        String sql = "insert into resorder( userid,address,tel,ordertime,deliverytime,ps,status) values( ?,?,?,now(),now(),?,0)";
        // 自增列的问题 roid订单号.
        KeyHolder keyHolder = new GeneratedKeyHolder();
        this.jdbcTemplate.update(  connection -> {
            // You need to specify Statement.RETURN_GENERATED_KEYS to
            // Statement.executeUpdate(), Statement.executeLargeUpdate() or
            // Connection.prepareStatement().
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, resorder.getUserid() + "");
            ps.setString(2, resorder.getAddress());
            ps.setString(3, resorder.getTel());
            ps.setString(4, resorder.getPs());
            return ps;
        }, keyHolder    );
        resorder.setRoid(keyHolder.getKey().intValue());
        return resorder;
    }
}
