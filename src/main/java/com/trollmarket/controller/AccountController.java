package com.trollmarket.controller;

import com.trollmarket.dto.account.RegisterAdminDTO;
import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.service.AccountService;
import com.trollmarket.service.BuyerService;
import com.trollmarket.service.SellerService;
import com.trollmarket.utility.Dropdown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private BuyerService buyerService;

    @Autowired
    private SellerService sellerService;

    @GetMapping("/loginForm")
    public String loginForm(Model model){
        List<Dropdown> role = Dropdown.getRoleDropdown();
        model.addAttribute("role",role);
        return "/account/login-form";
    }

    @GetMapping("/accesDenied")
    public String accesDenied(){
        return "/account/acces-denied";
    }

    @GetMapping("/registerForm")
    public String registerForm(@RequestParam String role, Model model){
        if(role.toLowerCase().equals("buyer")){
            RegisterDTO buyerAccount = new RegisterDTO();
            buyerAccount.setRole("Buyer");
            model.addAttribute("role",role);
            model.addAttribute("account",buyerAccount);
            return "/account/register-form";
        }else if(role.toLowerCase().equals("seller")){
            RegisterDTO sellerAccount = new RegisterDTO();
            sellerAccount.setRole("Seller");
            model.addAttribute("role",role);
            model.addAttribute("account",sellerAccount);
            return "/account/register-form";
        }else{
            RegisterAdminDTO adminAccount = new RegisterAdminDTO();
            adminAccount.setRole("Administrator");
            model.addAttribute("role",role);
            model.addAttribute("account",adminAccount);
            return "/account/register-form-admin";
        }
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("account") RegisterDTO registerDTO,Model model){
        if(registerDTO.getRole().toLowerCase().equals("buyer")){
            buyerService.save(registerDTO);
        }else{
            sellerService.save(registerDTO);
        }
        return "redirect:/account/loginForm";
    }
    @PostMapping("/registerAdmin")
    public String registerAdmin(@Valid @ModelAttribute("account") RegisterAdminDTO registerAdminDTO
            ,BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "/account/register-form-admin";
        }
        RegisterAdminDTO adminAccount = new RegisterAdminDTO();
        adminAccount.setRole("Administrator");
        model.addAttribute("role","Administrator");
        model.addAttribute("account",adminAccount);
        model.addAttribute("succesMsg","Succesfuly Adding New Admin");
        return "/account/register-form-admin";
    }


}
