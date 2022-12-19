package com.trollmarket.dto.profile;

import com.trollmarket.validation.BigDecimalLength;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class TopupDTO {


    @NotNull(message = "Please Insert Nominal Topup")
    @DecimalMin(value = "50000.0",inclusive = true, message = "Minimum Topup Rp.50.000,00")
//    @BigDecimalLength(minLength = 50000)
    private BigDecimal balance;

    public TopupDTO(){}

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
