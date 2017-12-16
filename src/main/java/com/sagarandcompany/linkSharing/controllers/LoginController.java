package com.sagarandcompany.linkSharing.controllers;

import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;
//    @Autowired
//    HttpSession httpSession;

    @PostMapping("/validate")
    @ResponseBody
    public Map validate(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession httpSession) {
        Map map = new HashMap();
        if (username.equals(httpSession.getAttribute("user"))) {
            map.put("message", "user already logined");
        } else {
            map = loginService.validate(username, password);
            if ((Boolean) map.get("status")) {
                httpSession.setAttribute("user", username);
            }
        }
        return map;
    }


}
