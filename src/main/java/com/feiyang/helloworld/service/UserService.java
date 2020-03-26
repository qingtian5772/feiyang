package com.feiyang.helloworld.service;

import com.feiyang.helloworld.entity.User;
import com.feiyang.helloworld.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> userList ( ) {
        return userMapper.getAllUser ( );
    }

    public int insert (User user) {
        return userMapper.insertUser (user);
    }

    public int delete (Integer id) {
        return userMapper.delUserById (id);
    }

    public int update (User user) {
        return userMapper.updateUser (user);
    }


}
