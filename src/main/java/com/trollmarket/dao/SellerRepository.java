package com.trollmarket.dao;

import com.trollmarket.dto.profile.GetProfilDTO;
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

    @Query("""
            SELECT new com.trollmarket.dto.profile.GetProfilDTO(
            sel.firstName,sel.lastName,acc.role,sel.address,sel.balance
            )
            FROM Seller as sel
            INNER JOIN sel.account as acc
            where acc.username = :username
            """)
    GetProfilDTO findProfilByUsername(@Param("username") String username);
}
