package com.trollmarket.service;

import com.trollmarket.dto.ProductDTO;
import com.trollmarket.entity.Product;

import java.util.List;

public interface ProductService {

    void save(ProductDTO product, Long sellerID);

    List<Product> findAllProduct();
}
