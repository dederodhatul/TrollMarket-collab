package com.trollmarket.service;

import com.trollmarket.dao.OrderDetailRepository;
import com.trollmarket.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{

    @Autowired
    OrderDetailRepository orderDetailRepository;

    private final int rowsInPage = 5;
    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Page<OrderDetail> findAllOrderDetail(Integer page, String sellerName, String buyerName) {
        Pageable pagination = PageRequest.of(page - 1,rowsInPage, Sort.by("id"));
        return orderDetailRepository.findAllOrderDetailBySellerAndBuyer(pagination, sellerName, buyerName);
    }
}
