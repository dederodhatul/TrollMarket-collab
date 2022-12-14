package com.trollmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class AppController {

    @GetMapping("/profile")
    public String profile(){

        return "profile";
    }

    @GetMapping("/shop")
    public String shop(){

        return "shop";
    }

    @GetMapping("/merchandise")
    public String merchandise(){

        return "merchandise";
    }



}
