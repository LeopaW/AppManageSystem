package com.xa.controller;

import com.xa.pojo.AppCategory;
import com.xa.service.AppcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/category")
public class AppCategoryController {

    @Autowired
    private AppcategoryService appcategoryService;

    @RequestMapping("/queryLevelTwoByLevelOne/{levelOneId}")
    @ResponseBody
    public List<AppCategory> queryLevelTwoByLevelOne(@PathVariable("levelOneId")Long id){
        List<AppCategory> levelTwo = appcategoryService.queryLevelTwoByLevelOne(id);
        return levelTwo;
    }

    //查询子类,根据父类id查询
    @RequestMapping("/queryLevelThreeByLevelTwo/{levelTwoId}")
    @ResponseBody
    public List<AppCategory> queryLevelThreeByLevelTwo(@PathVariable("levelTwoId")Long id){
        List<AppCategory> levelThree = appcategoryService.queryLevelThreeByLevelTwo(id);
        return levelThree;
    }


}

