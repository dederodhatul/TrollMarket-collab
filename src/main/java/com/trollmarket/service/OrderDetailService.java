package com.trollmarket.service;

import com.trollmarket.entity.OrderDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetail> findAll();

    Page<OrderDetail> findAllOrderDetail(Integer page, String sellerName, String buyerName);
}
