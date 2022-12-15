package com.trollmarket.service;

import com.trollmarket.dao.ProductRepository;
import com.trollmarket.dao.SellerRepository;
import com.trollmarket.dto.ProductDTO;
import com.trollmarket.entity.Product;
import com.trollmarket.entity.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    SellerRepository sellerRepository;

    private final int rowsInPage = 5;

    @Override
    public void save(ProductDTO dto, String username) {
        Seller seller =  sellerRepository.findByUsername(username);

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

    @Override
    public Page<Product> findAllProductPageable(int page) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        return productRepository.findAll(pagination);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        Product tempProduct = null;
        if(productOptional.isPresent()){
            tempProduct = productOptional.get();
        }
        return tempProduct;
    }

    @Override
    public ProductDTO findProductDTOById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                ()->{throw new RuntimeException("Product Not Found");
                });
        ProductDTO productDTO = new ProductDTO(product.getId(), product.getSeller().getId(),
                product.getName(),product.getCategory(),product.getDescription(),product.getPrice(),
                product.getDiscontinue());
        return productDTO;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }


}
