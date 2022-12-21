package com.trollmarket.controller;

import com.trollmarket.exceptionhandler.InsufficientFundsException;
import com.trollmarket.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/myCart")
public class MyCartController {

    @Autowired
    CartService cartService;

    @GetMapping("/index")
    public String myCart(@RequestParam(defaultValue = "1") Integer page, Model model, Authentication authentication){

        int totalPage = cartService.findAllCartPageable(page, authentication.getName()).getTotalPages();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("allCart", cartService.findAllCartPageable(page, authentication.getName()));
        return "myCart/myCart";
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("id") Long id){

        cartService.deleteById(id);
        return "redirect:/myCart/index";
    }

    @GetMapping("/purchase")
    public String purchaseAll(Authentication authentication, RedirectAttributes redirectAttributes){
        try{
            cartService.purchaseAll(authentication.getName());
        }catch (InsufficientFundsException e){
            redirectAttributes.addFlashAttribute("Error",e.getMessage());
        }
        return "redirect:/myCart/index";
    }


}
