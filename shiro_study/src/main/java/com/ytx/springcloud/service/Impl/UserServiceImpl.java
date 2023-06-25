package com.ytx.springcloud.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ytx.springcloud.entity.User;
import com.ytx.springcloud.mapper.UserMapper;
import com.ytx.springcloud.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserInfoByName(String name) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", name);
        User user = userMapper.selectOne(wrapper);
        return null;
    }
}
