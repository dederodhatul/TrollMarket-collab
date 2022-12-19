package com.trollmarket.service;

import com.trollmarket.dao.AccountRepository;
import com.trollmarket.dao.BuyerRepository;
import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.Account;
import com.trollmarket.entity.Buyer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(RegisterDTO registerDTO) {
        String hashPassword = passwordEncoder.encode(registerDTO.getPassword());
        Account account = new Account(registerDTO.getUsername(), hashPassword,
                registerDTO.getRole());
        Buyer buyer = new Buyer(registerDTO.getId(),
                registerDTO.getFirstName(),
                registerDTO.getLastName(),
                registerDTO.getAddress(),
                BigDecimal.valueOf(0),
                account);
        buyerRepository.save(buyer);
    }

    @Override
    public GetProfilDTO findProfilByUsername(String username) {
        System.out.println("Service Username : "+username);
        System.out.println("getProfil : "+ buyerRepository.findProfilByUsername(username));
        return buyerRepository.findProfilByUsername(username);
    }

    @Override
    public Buyer findBuyerByUsername(String username) {
        return buyerRepository.findByUsername(username);
    }


}
