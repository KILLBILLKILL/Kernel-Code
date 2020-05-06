package feihong.controller;

import feihong.model.Duck;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("user")
public class LoginController {

    @RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public Duck login(String username,String password)
    {
        System.out.printf("username=%s ,password=%s",username,password);
        return new Duck("LadyGaga",2);
    }

    @RequestMapping("/login2")

    public String login2()
    {
        return "Login.html";
    }
}
