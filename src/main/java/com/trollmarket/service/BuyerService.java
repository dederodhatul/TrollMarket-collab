package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;

public interface BuyerService {
    void save(RegisterDTO registerDTO);

    GetProfilDTO findProfilByUsername(String username);
}
