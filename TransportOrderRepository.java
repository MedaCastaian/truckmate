package com.truckmate.truckmate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.truckmate.truckmate.entity.TransportOrder;

@Repository
public interface TransportOrderRepository extends JpaRepository<TransportOrder, Long> {
    // Returnează comenzile pentru un client dat
    List<TransportOrder> findByClient(String client);

    // Returnează comenzile cu statusul specificat
    List<TransportOrder> findByStatus(String status);

    // Returnează comenzile care au tipul de marfă specificat
    List<TransportOrder> findByTipMarfa(String tipMarfa);
}
