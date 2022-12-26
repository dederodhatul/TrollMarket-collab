package com.trollmarket.dao;

import com.trollmarket.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    @Query(
            """
            SELECT ordet
            FROM OrderDetail AS ordet
            WHERE ordet.order.buyer.firstName LIKE %:buyerName% AND 
                  ordet.product.seller.firstName LIKE %:sellerName%
            """
    )
    Page<OrderDetail> findAllOrderDetailBySellerAndBuyer(Pageable pageable, @Param("sellerName") String sellerName,
                                                         @Param("buyerName") String buyerName);
}
