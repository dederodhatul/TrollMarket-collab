package com.trollmarket.dao;

import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.Buyer;
import com.trollmarket.entity.OrderDetail;
import com.trollmarket.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer,Long> {

    @Query("""
            SELECT new com.trollmarket.dto.profile.GetProfilDTO(
            byr.firstName,byr.lastName,acc.role,byr.address,byr.balance
            )
            FROM Buyer as byr
            INNER JOIN byr.account as acc
            where acc.username = :username
            """)
    GetProfilDTO findProfilByUsername(@Param("username") String username);

    @Query(
            """
              SELECT b 
              FROM Buyer as b
              WHERE b.account.username = :username
            """
    )
    Buyer findByUsername(@Param("username") String username);

    @Query("""
            SELECT byr
            FROM Buyer as byr
            INNER JOIN byr.account as acc
            where acc.username = :username
            """)
    Buyer findBuyerByUsername(@Param("username") String username);

    @Query(
            """
            SELECT ordet 
            FROM OrderDetail AS ordet
            INNER JOIN ordet.order AS ord
            WHERE ord.buyer.id = :id
            """
    )
    List<OrderDetail> findAllTransactionBuyer(@Param("id") Long id);

}
