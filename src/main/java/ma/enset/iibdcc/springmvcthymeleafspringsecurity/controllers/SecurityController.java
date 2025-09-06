package ma.enset.iibdcc.springmvcthymeleafspringsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/403")
    public String error403() {
        return "403"; // correspond à templates/403.html
    }
}
