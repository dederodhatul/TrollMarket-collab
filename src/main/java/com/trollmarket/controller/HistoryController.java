package com.trollmarket.controller;

import com.trollmarket.service.BuyerService;
import com.trollmarket.service.OrderDetailService;
import com.trollmarket.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    OrderDetailService orderDetailService;

    @Autowired
    SellerService sellerService;

    @Autowired
    BuyerService buyerService;

    @RequestMapping("/index")
    public String history(@RequestParam(defaultValue = "1") Integer page,
                          @RequestParam(value = "sellerName", required = false) String sellerName,
                          @RequestParam(value = "buyerName", required = false) String buyerName, Model model){
        sellerName = sellerName == null ? "" : sellerName;
        buyerName = buyerName == null ? "" : buyerName;

        int totalPages = orderDetailService.findAllOrderDetail(page, sellerName, buyerName).getTotalPages();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sellers", sellerService.findAllSeller());
        model.addAttribute("buyers", buyerService.findAllBuyer());
        model.addAttribute("searchSeller", sellerName);
        model.addAttribute("searchBuyer",buyerName);
        model.addAttribute("transactions", orderDetailService.findAllOrderDetail(page, sellerName, buyerName));

        return "history/history";
    }
}
