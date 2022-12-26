package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.OrderDetail;
import com.trollmarket.entity.Seller;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SellerService {
    void save(RegisterDTO registerDTO);

    Seller findSellerByUsername(String name);

    List<Seller> findAllSeller();

    GetProfilDTO findProfilByUsername(String username);

    Page<OrderDetail> findAllTransactionSeller(Integer page, String username);

}
