package ev.controller;

import ev.domain.Account;
import ev.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService as;

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户");
        //调用service方法
        List<Account> list = as.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("save")
    public String save(Account account) {
        as.saveAccount(account);
        return "redirect:findAll";
    }

}
