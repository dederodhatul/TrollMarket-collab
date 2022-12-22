package com.trollmarket.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
@Table(name="OrderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "OrderID")
    private Order order;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ProductID")
    private Product product;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "ShipmentID")
    private Shipment shipment;

    @Column(name = "Quantity", columnDefinition = "default 1")
    private Integer quantity;

    @Column(name = "SubTotal")
    private BigDecimal subTotal;

    public OrderDetail(){}

    public OrderDetail(Order order, Product product, Shipment shipment, Integer quantity, BigDecimal subTotal) {
        this.order = order;
        this.product = product;
        this.shipment = shipment;
        this.quantity = quantity;
        this.subTotal = subTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shipment getShipment() {
        return shipment;
    }

    public void setShipment(Shipment shipment) {
        this.shipment = shipment;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public String priceFormat(){
        Locale indonesia = new Locale("id", "ID");
        String indoFormat = NumberFormat.getCurrencyInstance(indonesia).format((this.subTotal));
        return indoFormat;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", order=" + order +
                ", product=" + product +
                ", shipment=" + shipment +
                ", quantity=" + quantity +
                ", subTotal=" + subTotal +
                '}';
    }
}
