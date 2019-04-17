package com.xa.service;

import com.github.pagehelper.PageInfo;
import com.xa.dto.AppInfoDTO;
import com.xa.pojo.AppInfo;
import com.xa.pojo.DataDictionary;

import java.util.List;

public interface AppInfoService {
    PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo<AppInfo> pageInfo);

    List<DataDictionary> queryALlAppStatus();

    List<DataDictionary> queryALlFlatforms();

    PageInfo<AppInfo> query(AppInfoDTO appInfoDTO);
}
