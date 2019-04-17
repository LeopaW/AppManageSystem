package com.xa.service;

import com.xa.pojo.DevUser;

public interface DevUserService {
    DevUser queryByCodePwd(String devCode, String devPassword);
}
