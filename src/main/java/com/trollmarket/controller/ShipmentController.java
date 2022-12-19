package com.trollmarket.controller;

import com.trollmarket.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/index")
    public String index(@RequestParam(defaultValue = "1") Integer page , Model model){
        Integer totalPage = shipmentService.findAllShipment(1).getTotalPages();

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPage);
        model.addAttribute("Shipments",shipmentService.findAllShipment(page));
        return "shipment/shipment";
    }
}
