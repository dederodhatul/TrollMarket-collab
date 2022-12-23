package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.Buyer;
import com.trollmarket.entity.Buyer;
import com.trollmarket.dto.profile.TopupDTO;
import com.trollmarket.entity.OrderDetail;
import org.springframework.data.domain.Page;

import java.util.List;


public interface BuyerService {
    void save(RegisterDTO registerDTO);

    GetProfilDTO findProfilByUsername(String username);

    Buyer findBuyerByUsername(String username);

    void topup(String username, TopupDTO topupDTO);

    Page<OrderDetail> findAllTransactionBuyer(Integer page, String username);

}
