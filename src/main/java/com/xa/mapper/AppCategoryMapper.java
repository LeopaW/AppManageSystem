package com.xa.mapper;

import com.xa.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppCategoryMapper {
    List<AppCategory> queryAllLevelOne();

    List<AppCategory> queryLevelByParentId(@Param("id") Long id);
}