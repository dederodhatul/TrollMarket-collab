package com.trollmarket.dao;

import com.trollmarket.entity.Cart;
import com.trollmarket.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
            SELECT pro
            FROM Product as pro WHERE pro.discontinue = 0
            AND pro.name LIKE %:name% AND pro.category LIKE %:category% AND pro.description LIKE %:desc%
          """
    )
    Page<Product> findAllProductContinue(Pageable pageable, @Param("name") String name, @Param("category") String category, @Param("desc") String desc);

    @Query("""
           SELECT pro 
           FROM Product AS pro
           INNER JOIN OrderDetail AS ordet ON pro.id = ordet.product.id
           """
    )
    List<Product> findProductOrder();

    @Query("""
            SELECT COUNT(pro)
            FROM Product AS pro
                INNER JOIN OrderDetail AS ordet ON pro.id = ordet.product.id
            WHERE pro.id = :id
            """
    )
    Long countOrderProduct(@Param("id") Long id);

    @Query("""
            SELECT COUNT(pro)
            FROM Product AS pro
                INNER JOIN Cart AS crt ON pro.id = crt.product.id
            WHERE pro.id = :id
            """
    )
    Long countCartProduct(@Param("id") Long id);

    @Query("""
            SELECT pro
            FROM Product AS pro
            INNER JOIN pro.seller as sel
            WHERE sel.account.username = :username
            """)
    Page<Product> findAllProductBySeller(@Param("username") String username,
                                         Pageable pageable);

}
