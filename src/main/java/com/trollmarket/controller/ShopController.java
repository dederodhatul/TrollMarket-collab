package com.trollmarket.controller;

import com.trollmarket.dto.myCart.CartDTO;
import com.trollmarket.dto.shipment.UpsertShipmentDTO;
import com.trollmarket.entity.Product;
import com.trollmarket.service.CartService;
import com.trollmarket.service.ProductService;
import com.trollmarket.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ProductService productService;

    @Autowired
    ShipmentService shipmentService;

    @Autowired
    CartService cartService;

    @RequestMapping("/index")
    public String shop(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "cat", required = false) String cat,
                       @RequestParam(value= "desc", required = false) String desc, Model model){

        name = name == null ? "" : name;
        cat = cat == null ? "" : cat;
        desc = desc == null ? "" : desc;

        Page<Product> products = productService.findAllProductContinue(page, name, cat, desc);
        int totalPage = productService.findAllProductContinue(page, name, cat, desc).getTotalPages();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("allShipment", shipmentService.findAllShipment());
        model.addAttribute("products", products);
        model.addAttribute("cart", new CartDTO());

        return "shop/shop";
    }

    @PostMapping("/addToCart")
    public String addToCart(@RequestParam(defaultValue = "1") Integer page,
                            Model model, @RequestParam("productID") Long id,
                            @Valid @ModelAttribute("cart") CartDTO cart,
                            BindingResult bindingresult, Authentication authentication){

        if(bindingresult.hasErrors()){
            Page<Product> products = productService.findAllProductContinue(page, "", "", "");
            int totalPage = productService.findAllProductContinue(page, "", "", "").getTotalPages();

            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPage);
            model.addAttribute("allShipment", shipmentService.findAllShipment());
            model.addAttribute("products", products);
            model.addAttribute("hasErrors",true);
            model.addAttribute("productID",id);

            return "shop/shop";
        }
        cartService.saveCart(cart, authentication.getName(), id);
        return "redirect:/myCart/index";
    }

    @GetMapping("/detailProduct")
    @ResponseBody
    public Product detailProduct(@RequestParam Long id){
        return productService.findById(id);
    }
}
