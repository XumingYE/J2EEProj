package com.Ka1.dao;

import com.Ka1.bean.Resfood;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName ResfoodDao
 * Description TODO
 * Author Ka1HuangZhe
 * Date Ka1HuangZhe 2020/6/3
 * Version 1.0
 */

public interface ResfoodDao {
    /**
     * 查询所有的菜s
     * @return
     */
     List<Resfood> findAllFood();
}
