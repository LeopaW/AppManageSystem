package com.xa.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import com.xa.controller.constant.CommonCodeConstant;
import com.xa.dto.AppInfoDTO;
import com.xa.mapper.AppInfoMapper;
import com.xa.mapper.DataDictionaryMapper;
import com.xa.pojo.AppInfo;
import com.xa.pojo.DataDictionary;
import com.xa.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appInfoService")
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    private AppInfoMapper appInfoMapper;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public PageInfo<AppInfo> queryByDevUserId(Long id,PageInfo<AppInfo> pageInfo) {
        // 去第几页,页码的大小
        PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
        List<AppInfo> list = appInfoMapper.queryByDevUserId(id);
        pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<DataDictionary> queryALlAppStatus() {
        return dataDictionaryMapper.queryALlAppStatus();
    }

    @Override
    public List<DataDictionary> queryALlFlatforms() {
        return dataDictionaryMapper.queryALlFlatforms();
    }

    @Override
    public PageInfo<AppInfo> query(AppInfoDTO appInfoDTO) {
        //
        PageHelper.startPage(appInfoDTO.getPageNum(),CommonCodeConstant.PAGE_SIZE);
        List<AppInfo> pageInfo = appInfoMapper.query(appInfoDTO);
        PageInfo<AppInfo> page = new PageInfo<>(pageInfo);
        return page;
    }
}
