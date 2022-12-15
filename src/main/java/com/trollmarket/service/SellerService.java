package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.Seller;

import java.util.List;

public interface SellerService {
    void save(RegisterDTO registerDTO);

    Seller findSellerByUsername(String name);

    List<Seller> findAllSeller();

    GetProfilDTO findProfilByUsername(String username);

}
