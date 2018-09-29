package cn.itcast.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author hujtb
 * @create on 2018-09-25-17:59
 */

@Controller
public class LoginController {
    //µÇÂ¼ 
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password) throws Exception{
        session.setAttribute("username", username);
        return "redirect:/items/queryItems.action";
    }
    @RequestMapping("/quit")
    public String quit(HttpSession session) throws Exception{
        session.invalidate();
        return "redirect:/items/queryItems.action";
    }
}
