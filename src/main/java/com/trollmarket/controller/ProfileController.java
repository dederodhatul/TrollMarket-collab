package com.trollmarket.controller;


import com.trollmarket.dto.profile.TopupDTO;
import com.trollmarket.entity.Order;
import com.trollmarket.entity.OrderDetail;
import com.trollmarket.service.BuyerService;
import com.trollmarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private BuyerService buyerService;

    @GetMapping("/index")
    public String profile(@RequestParam(defaultValue = "1") Integer page,
                          Authentication authentication, Model model){

        Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        authorities.stream().forEach(auth-> {
            if (auth.toLowerCase().equals("buyer")) {
                Page<OrderDetail> allTransactionBuyer = buyerService.findAllTransactionBuyer(page, authentication.getName());
                int totalPageBuyer = allTransactionBuyer.getTotalPages();
                model.addAttribute("topup", new TopupDTO());
                model.addAttribute("user", buyerService.findProfilByUsername(authentication.getName()));
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", totalPageBuyer);
                model.addAttribute("transactions", allTransactionBuyer);
            } else {
                Page<OrderDetail> allTransactionSeller = sellerService.findAllTransactionSeller(page, authentication.getName());
                int totalPageSeller = allTransactionSeller.getTotalPages();
                model.addAttribute("user", sellerService.findProfilByUsername(authentication.getName()));
                model.addAttribute("currentPage", page);
                model.addAttribute("totalPages", totalPageSeller);
                model.addAttribute("transactions", allTransactionSeller);
            }
        });

        return "profile/profile-index";
    }

    @PostMapping("/topup")
    private String topup(@Valid @ModelAttribute("topup") TopupDTO topupDTO, BindingResult bindingResult,
                         Authentication authentication,Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("hasErrors",true);
            model.addAttribute("user",buyerService.findProfilByUsername(authentication.getName()));
            return "/profile/profile-index";
        }
        buyerService.topup(authentication.getName(),topupDTO);
        return "redirect:/profile/index";
    }

}
