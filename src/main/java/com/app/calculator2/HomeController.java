package com.app.calculator2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping
    @ResponseBody
    public String home() {
        return "Hello World";
    }
}
