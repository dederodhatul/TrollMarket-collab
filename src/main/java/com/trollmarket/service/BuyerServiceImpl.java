package com.trollmarket.service;

import com.trollmarket.dao.AccountRepository;
import com.trollmarket.dao.BuyerRepository;
import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.dto.profile.TopupDTO;
import com.trollmarket.entity.Account;
import com.trollmarket.entity.Buyer;
import com.trollmarket.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final int rowsInPage = 5;

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
        return buyerRepository.findProfilByUsername(username);
    }

    @Override
    public Buyer findBuyerByUsername(String username) {
        return buyerRepository.findByUsername(username);
    }

    public void topup(String username, TopupDTO topupDTO) {
        Buyer buyer = buyerRepository.findBuyerByUsername(username);
        buyer.setBalance(buyer.getBalance().add(topupDTO.getBalance()));
        buyerRepository.save(buyer);

    }

    @Override
    public Page<OrderDetail> findAllTransactionBuyer(Integer page, String username) {
        Buyer buyer = findBuyerByUsername(username);
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        return buyerRepository.findAllTransactionBuyer(pagination, buyer.getId());
    }

}
