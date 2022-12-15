package com.trollmarket.service;

import com.trollmarket.dao.ProductRepository;
import com.trollmarket.dao.SellerRepository;
import com.trollmarket.dto.ProductDTO;
import com.trollmarket.entity.Product;
import com.trollmarket.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public void save(ProductDTO dto, Long sellerID) {
        Seller seller = sellerRepository.findById(sellerID).get();

        Product product = new Product(
                dto.getId(),
                seller,
                dto.getName(),
                dto.getCategory(),
                dto.getDescription(),
                dto.getPrice(),
                dto.getDiscontinue()
        );

        productRepository.save(product);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

}
