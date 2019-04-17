package com.xa.mapper;

import com.xa.pojo.DevUser;
import org.apache.ibatis.annotations.Param;

public interface DevUserMapper {

    DevUser queryByCodePwd(@Param("devCode") String devCode, @Param("devPassword") String devPassword);
}