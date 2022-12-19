package com.trollmarket.dao;

import com.trollmarket.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment,Long> {
}
