package com.xa.service;

import com.xa.pojo.AppCategory;

import java.util.List;

public interface AppcategoryService {
    List<AppCategory> queryAllLevelOne();

    List<AppCategory> queryLevelTwoByLevelOne(Long id);

    List<AppCategory> queryLevelThreeByLevelTwo(Long id);
}
