package com.trollmarket.controller;

import com.trollmarket.dto.ProductDTO;
import com.trollmarket.service.ProductService;
import com.trollmarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/merchandise")
public class MerchandiseController {

    @Autowired
    ProductService productService;

    @Autowired
    SellerService sellerService;

    @GetMapping("/index")
    public String merchandise(@RequestParam(defaultValue = "1") Integer page, Model model){
        int totalPage = productService.findAllProductPageable(page).getTotalPages();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("products", productService.findAllProductPageable(page));
        return "merchandise/merchandise";
    }

    @GetMapping("/formAddProduct")
    public String formAddProduct(Model model){

        model.addAttribute("product", new ProductDTO());
        return "merchandise/formProduct";
    }

    @PostMapping("/addProduct")
    public String addProduct(@Valid @ModelAttribute("product") ProductDTO product, BindingResult bindingResult, Authentication authentication){

        if(bindingResult.hasErrors()){
            return "merchandise/formProduct";
        }

        productService.save(product, authentication.getName());

        return "redirect:/merchandise/index";
    }

    @GetMapping("/discontinue")
    public String discontinue(@RequestParam("id") Long id,
                              @RequestParam("page") Integer page,
                              Authentication authentication){
        ProductDTO dto = productService.findProductDTOById(id);
        dto.setDiscontinue(true);
        productService.save(dto, authentication.getName());

        return "redirect:/merchandise/index?page="+page;
    }

    @GetMapping("/detailProduct")
    public String detailProduct(@RequestParam("id") Long id, Model model){
        ProductDTO dto = productService.findProductDTOById(id);

        model.addAttribute("products", productService.findAllProduct());
        model.addAttribute("productDTO", dto);
        return "merchandise/merchandise";
    }

    @GetMapping("/formEdit")
    public String formEdit(@RequestParam("id") Long id, Model model){

        model.addAttribute("product", productService.findProductDTOById(id));
        return "merchandise/formProduct";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id){

        productService.delete(id);
        return "redirect:/merchandise/index";
    }


}
