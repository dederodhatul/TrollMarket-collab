package com.trollmarket.service;

import com.trollmarket.entity.Shipment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShipmentService {

    List<Shipment> findAllShipment();

    Page<Shipment> findAllShipmentPageable(int page);

    Page<Shipment> findAllShipment(Integer page);

}
