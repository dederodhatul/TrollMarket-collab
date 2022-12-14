package com.trollmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/buyer")
public class BuyerController {

    @GetMapping("/formAddProduct")
    public String formAddProduct(){

        return "buyer/formProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(){

        return "redirect:/page/merchandise";
    }
}
