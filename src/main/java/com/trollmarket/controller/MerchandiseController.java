package com.trollmarket.controller;

import com.trollmarket.dto.ProductDTO;
import com.trollmarket.entity.Seller;
import com.trollmarket.service.ProductService;
import com.trollmarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseController {

    @Autowired
    ProductService productService;

    @Autowired
    SellerService sellerService;

    @GetMapping("/index")
    public String merchandise(Model model){

        model.addAttribute("products", productService.findAllProduct());

        return "merchandise/merchandise";
    }

    @GetMapping("/formAddProduct")
    public String formAddProduct(Model model){

        model.addAttribute("product", new ProductDTO());
        return "merchandise/formProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") ProductDTO product, Authentication authentication){
        System.out.println("authentication : " + authentication.getName());
        Seller seller =  sellerService.findSellerByUsername(authentication.getName());

        productService.save(product, seller.getId());

        return "redirect:/merchandise/index";
    }



}
