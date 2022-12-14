package com.trollmarket.service;

import com.trollmarket.dao.ProductRepository;
import com.trollmarket.dto.ProductDTO;
import com.trollmarket.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(ProductDTO dto) {
        Product product = new Product(
                dto.getId(),
                dto.getName(),
                dto.getCategory(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getDiscontinue()
        );

        productRepository.save(product);
    }
}
