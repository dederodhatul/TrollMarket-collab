package com.trollmarket.service;

import com.trollmarket.dao.AccountRepository;
import com.trollmarket.dao.BuyerRepository;
import com.trollmarket.dto.RegisterDTO;
import com.trollmarket.entity.Account;
import com.trollmarket.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public void save(RegisterDTO registerDTO) {
        Account account = new Account(registerDTO.getUsername(), registerDTO.getPassword(),
                registerDTO.getRole());
        Buyer buyer = new Buyer(registerDTO.getId(),
                registerDTO.getFirstName(),
                registerDTO.getLastName(),
                registerDTO.getAddress(),
                BigDecimal.valueOf(0),
                account);
        buyerRepository.save(buyer);
    }
}
