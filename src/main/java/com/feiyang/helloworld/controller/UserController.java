package com.feiyang.helloworld.controller;

import com.feiyang.helloworld.entity.User;
import com.feiyang.helloworld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    //显示页面 所有的用户
    @RequestMapping("list")
    public  String userList(Model model){
        model.addAttribute ("users",userService.userList ());
        return "list";
    }

    /*添加用户页面*/
    @RequestMapping("/add")
    public String addUser(ModelMap map){
        map.addAttribute("user",new User());
        return "add";
    }

    /*添加完用户后重定向到list页面*/
    @RequestMapping("/saveI")
    public String saveI(@ModelAttribute User user){

        userService.insert(user);
        return "redirect:/list";
    }
//删除数据
    @RequestMapping("/del")
    public String deleteUser(Integer id)
    {
        userService.delete (id);
        return "redirect:/list";

    }
    /*更新用户页面*/
    @RequestMapping("/update")
    public String updateUser(ModelMap map){
        map.addAttribute("user",new User());
        return "update";
    }
    /*更新完用户后重定向到list页面*/
    @RequestMapping("/saveU")
    public String saveU(@ModelAttribute User user){
        userService.update(user);
        return "redirect:/list";
    }

//首页方法
    @RequestMapping("/index")
    public String index()
    {
        return "index";
    }


}
