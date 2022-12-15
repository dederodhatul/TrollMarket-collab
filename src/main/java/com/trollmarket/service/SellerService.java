package com.trollmarket.service;

import com.trollmarket.dto.RegisterDTO;
import com.trollmarket.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SellerService {
    void save(RegisterDTO registerDTO);

    Seller findSellerByUsername(String name);

    List<Seller> findAllSeller();

}
