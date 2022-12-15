package com.trollmarket.dao;

import com.trollmarket.dto.profile.GetProfilDTO;
import com.trollmarket.entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
}
