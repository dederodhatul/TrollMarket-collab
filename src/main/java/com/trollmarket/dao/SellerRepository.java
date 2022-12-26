package com.trollmarket.dao;

import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.OrderDetail;
import com.trollmarket.entity.Seller;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

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

    @Query(
            """
            SELECT ordet 
            FROM OrderDetail AS ordet
            WHERE ordet.product.seller.id = :id
            """
    )
    Page<OrderDetail> findAllTransactionSeller(Pageable pageable, @Param("id") Long id);
}
