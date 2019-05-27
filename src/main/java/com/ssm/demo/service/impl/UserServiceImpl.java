package com.ssm.demo.service.impl;

import com.ssm.demo.dao.UserMapper;
import com.ssm.demo.pojo.User;
import com.ssm.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }
}
