package com.roger.client.service;

import com.roger.bean.User;
import com.roger.client.po.UserVo;
import com.roger.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zx on 2017/3/18.
 */
@Service("userClientRemote")
public class UserClientServiceImpl implements UserClientService{
    @Autowired
    private UserService userService;

    @Override
    public UserVo getUserById(Long id) {
        User user = userService.getUserById(id);
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(user,vo);
        return vo;
    }
}
