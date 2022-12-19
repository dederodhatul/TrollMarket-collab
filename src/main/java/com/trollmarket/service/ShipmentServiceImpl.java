package com.trollmarket.service;

import com.trollmarket.dao.ShipmentRepository;
import com.trollmarket.entity.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    private final int rowsInPage = 5;

    @Override

    public List<Shipment> findAllShipment() {
        return shipmentRepository.findAll();
    }

    @Override
    public Page<Shipment> findAllShipmentPageable(int page) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));

        return shipmentRepository.findAll(pagination);
    }

    public Page<Shipment> findAllShipment(Integer page) {
        Pageable pagination = PageRequest.of(page - 1, rowsInPage, Sort.by("id"));
        return shipmentRepository.findAll(pagination);
    }

}
