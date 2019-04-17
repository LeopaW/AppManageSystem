package com.xa.service.impl;

import com.xa.mapper.AppCategoryMapper;
import com.xa.pojo.AppCategory;
import com.xa.service.AppcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("appcategoryService")
public class AppcategoryServiceImpl implements AppcategoryService {

    @Autowired
    private AppCategoryMapper appCategoryMapper;

    @Override
    public List<AppCategory> queryAllLevelOne() {
        return appCategoryMapper.queryAllLevelOne();
    }

    @Override
    public List<AppCategory> queryLevelTwoByLevelOne(Long id) {
        return appCategoryMapper.queryLevelByParentId(id);
    }

    @Override
    public List<AppCategory> queryLevelThreeByLevelTwo(Long id) {
        return appCategoryMapper.queryLevelByParentId(id);
    }
}
