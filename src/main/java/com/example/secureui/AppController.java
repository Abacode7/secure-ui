package com.example.secureui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/")
    public String loadHome(){
        return "home";
    }

    @GetMapping("/details")
    public String loadDetails(){
        return "details";
    }
}
