package com.xa.controller;

import com.xa.pojo.DevUser;
import com.xa.service.AppInfoService;
import com.xa.service.DevUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/dev")
public class DevUserController {

    @Autowired
    private DevUserService devUserService;


    @Autowired
    private AppInfoService appInfoService;

    @RequestMapping("/toLogin")
    public String index(){
        return "dev/login";
    }

    @RequestMapping("/login")
    public String login(@RequestParam("devCode")String devCode, @RequestParam("devPassword")String devPassword, Model model, HttpSession session){

        DevUser devUser = devUserService.queryByCodePwd(devCode,devPassword);
        if(devUser != null){
            session.setAttribute("devUser",devUser);
            return "dev/index";
        }else{
            model.addAttribute("errMsg","登录失败");
            return "dev/login";
        }

    }


    @RequestMapping("/logout/{id}")
    public String logout(@PathVariable("id")Long id,HttpSession session){
//        devUserService.logout(id);   看数据有没有标记登录的字段
        session.removeAttribute("devUser");
        session.invalidate();
        return "redirect:/";
    }
}
