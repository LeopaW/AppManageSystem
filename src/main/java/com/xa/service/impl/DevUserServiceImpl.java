package com.xa.service.impl;

import com.xa.mapper.DevUserMapper;
import com.xa.pojo.DevUser;
import com.xa.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("devUserService")
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;

    @Override
    public DevUser queryByCodePwd(String devCode, String devPassword) {
        return devUserMapper.queryByCodePwd(devCode,devPassword);
    }
}
