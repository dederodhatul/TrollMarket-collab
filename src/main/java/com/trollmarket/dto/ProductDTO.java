package com.trollmarket.dto;

import com.trollmarket.validation.BigDecimalLength;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {
    private Long id;

    private Long sellerID;

    @NotBlank(message = "name is required!")
    private String name;

    @NotBlank(message = "category is required!")
    private String category;

    private String description;

    @NotNull(message = "price is required!")
    @BigDecimalLength(minLength = 3)
    private BigDecimal price;

    private Boolean discontinue;

    public ProductDTO(){}

    public ProductDTO(Long id, Long sellerID, String name, String category, String description, BigDecimal price, Boolean discontinue) {
        this.id = id;
        this.sellerID = sellerID;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.discontinue = discontinue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getSellerID() {
        return sellerID;
    }

    public void setSellerID(long sellerID) {
        this.sellerID = sellerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getDiscontinue() {
        return discontinue;
    }

    public void setDiscontinue(Boolean discontinue) {
        this.discontinue = discontinue;
    }

    public String getStatus(){
        if(this.discontinue == true){
            return "Yes";
        }else{
            return "No";
        }
    }

}
