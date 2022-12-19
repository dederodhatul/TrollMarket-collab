package com.trollmarket.service;

import com.trollmarket.dto.account.RegisterAdminDTO;
import com.trollmarket.dto.account.RegisterDTO;

public interface AccountService {
    void registerAccount(RegisterAdminDTO dto);
}
