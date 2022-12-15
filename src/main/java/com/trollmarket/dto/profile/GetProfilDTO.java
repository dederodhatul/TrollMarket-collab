package com.trollmarket.dto.profile;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class GetProfilDTO {
    private String firstName;
    private String lastName;
    private String role;
    private String address;
    private BigDecimal balance;

    public GetProfilDTO(){}

    public GetProfilDTO(String firstName, String lastName, String role, String address, BigDecimal balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.address = address;
        this.balance = balance;
    }
    public String getFullName(){
        return this.firstName +' '+ this.lastName;
    }

    public String getBalanceIDR(){
        Locale indonesia = new Locale("id", "ID");
        String indoFormat = NumberFormat.getCurrencyInstance(indonesia).format(this.balance);
        return indoFormat;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
