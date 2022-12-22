package com.trollmarket.dto.profile;

import com.trollmarket.entity.Buyer;
import com.trollmarket.entity.Product;
import com.trollmarket.entity.Shipment;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransactionHistDTO {

    private LocalDate date;

    private Product product;

    private Long quantity;

    private Shipment shipment;

    private BigDecimal totalPrice;

    public TransactionHistDTO(){}

    public TransactionHistDTO(LocalDate date, Product product, Long quantity, Shipment shipment, BigDecimal totalPrice) {
        this.date = date;
        this.product = product;
        this.quantity = quantity;
        this.shipment = shipment;
        this.totalPrice = totalPrice;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
