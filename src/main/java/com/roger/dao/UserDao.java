package com.roger.dao;

import com.roger.bean.User;
import com.roger.spring.bean.MyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * Created by zx on 2017/3/13.
 */
@Repository
public class UserDao extends MyBatisDao {
    public UserDao() {
        super("t_user");
    }

    public void insert(User user){
        super.insert("insert",user);
    }
}
