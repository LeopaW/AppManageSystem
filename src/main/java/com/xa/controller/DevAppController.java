package com.xa.controller;

import com.github.pagehelper.PageInfo;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;
import com.xa.dto.AppInfoDTO;
import com.xa.pojo.AppCategory;
import com.xa.pojo.AppInfo;
import com.xa.pojo.DataDictionary;
import com.xa.service.AppInfoService;
import com.xa.service.AppcategoryService;
import com.xa.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/app")
public class DevAppController {

    @Autowired
    private AppInfoService appInfoService;

    @Autowired
    private DataDictionaryService dataDictionaryService;

    @Autowired
    private AppcategoryService appcategoryService;

    @RequestMapping("/index/devId/{id}")
    public String index(@PathVariable("id")Long id, Model model){
        System.out.println(id);
        PageInfo<AppInfo> pageInfo = new PageInfo<>();
        pageInfo.setPageSize(5);
        pageInfo.setPageNum(1);
        pageInfo = appInfoService.queryByDevUserId(id,pageInfo);

        //查询所有的平台
        List<DataDictionary> appFlatForms = appInfoService.queryALlFlatforms();
        //查询所有的APP的状态
        List<DataDictionary> appStatuses = appInfoService.queryALlAppStatus();
        //查询所有的一级分类
        List<AppCategory> levelOne = appcategoryService.queryAllLevelOne();

        model.addAttribute("page",pageInfo);
        model.addAttribute("appFlatfroms",appFlatForms);
        model.addAttribute("appStatuses",appStatuses);
        model.addAttribute("levelOne",levelOne);
        return "app/index";
    }


    @RequestMapping("/query")
    public String query(AppInfoDTO appInfoDTO){

        PageInfo<AppInfo> pageInfo = appInfoService.query(appInfoDTO);
        return "app/index";
    }
}
