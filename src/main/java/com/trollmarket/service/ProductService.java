package com.trollmarket.service;

import com.trollmarket.dto.ProductDTO;
import com.trollmarket.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    void save(ProductDTO product, String username);

    List<Product> findAllProduct();

    Page<Product> findAllProductPageable(int page);

    Product findById(Long id);

    ProductDTO findProductDTOById(Long id);

    void delete(Long id);

}
