package com.swordcode.grupo1.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/", "/index" })

public class IndexController {
    @GetMapping
    public String main(Model model) {
        return "index";
    }
}