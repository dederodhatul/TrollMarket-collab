package com.trollmarket.dao;

import com.trollmarket.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends JpaRepository<Seller,Long> {

    @Query(
            """
              SELECT s 
              FROM Seller as s 
              WHERE s.account.username = :username
            """
    )
    Seller findByUsername(@Param("username") String username);
}
