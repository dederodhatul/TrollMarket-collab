package com.trollmarket.service;

import com.trollmarket.dao.BuyerRepository;
import com.trollmarket.dao.CartRepository;
import com.trollmarket.dao.ProductRepository;
import com.trollmarket.dao.ShipmentRepository;
import com.trollmarket.dto.myCart.CartDTO;
import com.trollmarket.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    BuyerRepository buyerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ShipmentRepository shipmentRepository;

    private final int rowsInPage = 5;

    @Override
    public Cart findById(Long id) {
        Optional<Cart> cartOptional = cartRepository.findById(id);
        Cart cart = null;

        if(cartOptional.isPresent()){
            cart = cartOptional.get();
        }

        return cart;
    }

    @Override
    public void saveCart(CartDTO cartDTO,  String usernameBuyer, Long productID) {
        Cart cart = new Cart(
                buyerRepository.findByUsername(usernameBuyer),
                productRepository.findById(productID).get(),
                cartDTO.getQuantity(),
                shipmentRepository.findById(cartDTO.getShipmentID()).get()
        );

        cartRepository.save(cart);
    }

    @Override
    public List<Cart> findAllCart() {
        return cartRepository.findAll();
    }

    @Override
    public Page<Cart> findAllCartPageable(int page, String username) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        return cartRepository.findAllCartBuyer(pagination, username);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.deleteById(id);
    }


}
