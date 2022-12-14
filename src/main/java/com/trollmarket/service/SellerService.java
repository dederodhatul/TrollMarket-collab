package com.trollmarket.service;

import com.trollmarket.dto.RegisterDTO;
import com.trollmarket.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerService {
    void save(RegisterDTO registerDTO);
}
