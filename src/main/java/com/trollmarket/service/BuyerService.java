package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
<<<<<<< HEAD
import com.trollmarket.entity.Buyer;
=======

import com.trollmarket.entity.Buyer;

>>>>>>> upstream/main
import com.trollmarket.dto.profile.TopupDTO;


public interface BuyerService {
    void save(RegisterDTO registerDTO);

    GetProfilDTO findProfilByUsername(String username);
<<<<<<< HEAD
=======

>>>>>>> upstream/main

    Buyer findBuyerByUsername(String username);

    void topup(String username, TopupDTO topupDTO);
<<<<<<< HEAD

=======
>>>>>>> upstream/main
}
