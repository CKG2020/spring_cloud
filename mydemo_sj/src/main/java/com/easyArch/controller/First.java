package com.easyArch.controller;

import com.easyArch.entity.User;
import com.easyArch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@EnableRedisHttpSession
@RequestMapping("/")
@Controller
public class First {

    @Autowired
    UserService userService ;
    @Autowired
    HttpServletRequest request;

    @RequestMapping("Login")
    public String test(){
        HttpSession session = request.getSession();
        if(session.getAttribute("user")!=null){
            session.removeAttribute("user");
            session.removeAttribute("userBoard");
        }
        return "First/Login";
    }
    @RequestMapping(value="")
    public String index(){
        return "index";
    }

    @RequestMapping("LoginAdmin")
    public String test2(){ return "First/LoginAdmin"; }

    @RequestMapping(value = "ok" ,method = RequestMethod.POST)
    @ResponseBody
    public Object ok(@RequestParam String Sno, String Spwd){
        User user;
        Object obj = userService.login(Sno,Spwd);
        if (obj.equals(1)||obj.equals(0)){
            return obj.toString();
        }
        HttpSession session = request.getSession();
        user=(User)obj;
        session.setAttribute("user",user);
        return user;
    }//用户登录

//    @RequestMapping("stu")//登录成功跳转页面
//    public String suc(){
//        if(request.getSession().getAttribute("user")==null){
//            return "First/Login";
//        }else{
//            return "stu/MoreInfo";
//        }
//    }

//    跳转后再把user查出来
    @RequestMapping("search")
    @ResponseBody
    public Object search(){
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));
        return session.getAttribute("user");
    }

    @RequestMapping("Register")//用户注册
    public String register(){
        return "First/Register";
    }


    @RequestMapping("/admin")
    @ResponseBody//管理员
    public String admin(@RequestParam String Sno, String Spwd){
        System.out.println(userService.adminLogin(Sno,Spwd));
        if(userService.adminLogin(Sno,Spwd)!=null){
            return "ok";
        }
        return null;
    }
    @RequestMapping("findall")//登录成功跳转页面
    public String all(){
        return "admin/demo";
    }

    @RequestMapping("isused")
    @ResponseBody
    public String used(@RequestParam String Sno){
        System.out.println(Sno);
        Object obj = userService.findUserBySno(Sno);
        if(obj!=null){
            return "此用户已存在!";
        }else{
            return "ok";
        }

    }

    //method = RequestMethod.POST    为什么括号里加了这个方法后，我就接不到sno了
    @RequestMapping(value = "addUser" )
    public String submit(@RequestParam String Sno, String Spwd){
        userService.addUser(Sno,Spwd);
        User user = userService.findUserBySno(Sno);
        System.out.println(Sno);
        HttpSession session = request.getSession();

        session.setAttribute("user",user);
        System.out.println("user"+user);

        return "stu/MoreInfo";
    }

}
