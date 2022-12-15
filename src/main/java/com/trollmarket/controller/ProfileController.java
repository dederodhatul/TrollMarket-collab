package com.trollmarket.controller;


import com.trollmarket.service.BuyerService;
import com.trollmarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/index")
    public String profile(Authentication authentication, Model model){
        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        authorities.stream().forEach(auth->{
            if(auth.toLowerCase().equals("buyer")){
                model.addAttribute("user",buyerService.findProfilByUsername(authentication.getName()));
            }else{
                model.addAttribute("user",sellerService.findProfilByUsername(authentication.getName()));
            }
        });
        return "profile/profile-index";
    }


}
