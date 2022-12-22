package com.trollmarket.service;
import com.trollmarket.dao.ShipmentRepository;
import com.trollmarket.dto.shipment.UpsertShipmentDTO;
import com.trollmarket.entity.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements ShipmentService{

    @Autowired
    ShipmentRepository shipmentRepository;


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

    @Override
    public void save(UpsertShipmentDTO upsertShipmentDTO) {
        Shipment shipment = new Shipment(
                upsertShipmentDTO.getId(),
                upsertShipmentDTO.getName(),
                upsertShipmentDTO.getPrice(),
                upsertShipmentDTO.getService()
        );
        if(upsertShipmentDTO.getId()!=null){
            shipment.setService(shipmentRepository.findById(upsertShipmentDTO.getId()).get().getService());
        }
        shipmentRepository.save(shipment);
    }

    @Override
    public UpsertShipmentDTO findUpsertShipmentById(Long id) {
        Shipment shipment = shipmentRepository.findById(id).get();
        UpsertShipmentDTO upsertShipmentDTO = new UpsertShipmentDTO(
                shipment.getId(),
                shipment.getName(),
                shipment.getPrice(),
                shipment.getService()
        );
        return upsertShipmentDTO;
    }

    @Override
    public void updateService(Long id) {
        Shipment shipment = shipmentRepository.findById(id).get();
        shipment.setService(false);
        shipmentRepository.save(shipment);
    }

    @Override
    public List<Shipment> findAllShipmentService() {
        return shipmentRepository.findAllShipmentService();
    }

}
