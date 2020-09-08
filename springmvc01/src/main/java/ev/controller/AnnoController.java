package ev.controller;

import ev.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

//常用注解

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把msg存入到session域中
public class AnnoController {

    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("执行了...");
        System.out.println(username);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("a") User user){
        System.out.println("testModelAttribute执行了...");
        System.out.println(user);
        return "success";
    }

    //该方法优先执行
    @ModelAttribute
    public void showUser(String name, Map<String,User> map){
        System.out.println("showUser执行了...");
        //模拟通过用户查询数据库
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        map.put("a",user);
    }
    /*@ModelAttribute
    public User showUser(String name){
        System.out.println("showUser执行了...");
        //模拟通过用户查询数据库
        User user = new User();
        user.setName(name);
        user.setAge(20);
        user.setDate(new Date());
        return user;
    }*/

    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes执行了...");
        //底层会存储到request域对象中
        model.addAttribute("msg","ev");
        return "success";
    }

    @RequestMapping("/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes执行了...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping("/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("delSessionAttributes执行了...");
        status.setComplete();
        return "success";
    }
}
