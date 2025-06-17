package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "index"; // This will return the index.html file from the templates directory
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello"; // This will return the hello.html file from the templates directory
    }
}
