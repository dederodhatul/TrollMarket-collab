package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.Buyer;

public interface BuyerService {
    void save(RegisterDTO registerDTO);

    GetProfilDTO findProfilByUsername(String username);

    Buyer findBuyerByUsername(String username);
}
