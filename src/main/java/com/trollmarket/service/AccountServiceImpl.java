package com.trollmarket.service;

import com.trollmarket.config.ApplicationUserDetails;
import com.trollmarket.dao.AccountRepository;
import com.trollmarket.dto.account.RegisterDTO;
import com.trollmarket.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {


    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void registerAccount(RegisterDTO dto) {

        String hashPassword = passwordEncoder.encode(dto.getPassword());
        Account account = new Account(dto.getUsername(),
                hashPassword, dto.getRole());
        accountRepository.save(account);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> nullableEntity = accountRepository.findById(username);
        Account account = accountRepository.findById(username).orElseThrow(
                ()->{
                    throw new UsernameNotFoundException("Invalid Username or Password");
                }
        );
        return new ApplicationUserDetails(account);
    }
}
