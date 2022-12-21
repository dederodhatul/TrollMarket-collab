package com.trollmarket.dto.shipment;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class UpsertShipmentDTO {

    private Long id;
    @NotBlank(message = "name cannot be blank")
    private String name;
    @NotNull(message = "Price cannot be null")
    private BigDecimal price;
    private Boolean service;


    public UpsertShipmentDTO(){}

    public UpsertShipmentDTO(Long id, String name, BigDecimal price, Boolean service) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getService() {
        return service;
    }

    public void setService(Boolean service) {
        this.service = service;
    }
}
