package com.trollmarket.service;

import com.trollmarket.dto.shipment.UpsertShipmentDTO;
import com.trollmarket.entity.Shipment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ShipmentService {

    List<Shipment> findAllShipment();

    Page<Shipment> findAllShipmentPageable(int page);

    Page<Shipment> findAllShipment(Integer page);

    void save(UpsertShipmentDTO upsertShipmentDTO);

    UpsertShipmentDTO findUpsertShipmentById(Long id);

    void updateService(Long id);

    List<Shipment> findAllShipmentService();

}
