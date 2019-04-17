package com.xa.mapper;

import com.xa.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryMapper {

    List<DataDictionary> queryALlAppStatus();

    List<DataDictionary> queryALlFlatforms();
}