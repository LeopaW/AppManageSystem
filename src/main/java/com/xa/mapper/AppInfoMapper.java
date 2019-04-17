package com.xa.mapper;

import com.xa.dto.AppInfoDTO;
import com.xa.pojo.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppInfoMapper {

    List<AppInfo> queryByDevUserId(@Param("devUserId") Long id);

    List<AppInfo> query(AppInfoDTO appInfoDTO);
}