package ev.controller;

import ev.domain.Info;
import ev.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    @RequestMapping("/login")
    public String login(Info info, Model model) {
        Info loginInfo = infoService.login(info);
        if (loginInfo != null) {
            model.addAttribute("loginInfo",loginInfo);
            return "list";
        } else {
            return "loginError";
        }
    }

}
