package ev.controller;

import ev.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString执行了...");
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("ev");
        user.setPassword("123");
        user.setAge(18);
        model.addAttribute("user", user);
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid执行了...");
        /*//转发
        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);*/

        /*//重定向
        response.sendRedirect(request.getContextPath()+"/index.jsp");*/

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        //直接进行响应
        response.getWriter().print("hello,你好");

        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView执行了...");
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        //模拟从数据库中查询出User对象
        User user = new User();
        user.setUsername("ev");
        user.setPassword("123");
        user.setAge(18);
        //把user对象存储到mv对象中，也会把user对象存入到request对象
        mv.addObject("user",user);
        //跳转到那个页面
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user) {
        System.out.println("testAjax执行了...");
        //客户端发送ajax的请求，传的是json字符串，后端把json字符串封装到user对象中
        System.out.println(user);
        //做响应，模拟查询数据库
        user.setUsername("zhao");
        user.setAge(22);
        //做响应
        return user;
    }

}
