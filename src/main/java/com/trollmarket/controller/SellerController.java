package com.trollmarket.controller;

import com.trollmarket.dto.ProductDTO;
import com.trollmarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    ProductService productService;

    @GetMapping("/formAddProduct")
    public String formAddProduct(Model model){

        model.addAttribute("product", new ProductDTO());
        return "seller/formProduct";
    }


    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") ProductDTO product, Authentication authentication){
        System.out.println("authentication : " + authentication.getName());
//        productService.save(product);

        return "redirect:/page/merchandise";
    }
}
