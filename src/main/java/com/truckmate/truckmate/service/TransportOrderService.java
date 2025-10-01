package com.truckmate.truckmate.service;

import com.truckmate.truckmate.entity.TransportOrder;
import com.truckmate.truckmate.repository.TransportOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransportOrderService {

    private final TransportOrderRepository repository;

    public List<TransportOrder> getAll() {
        return repository.findAll();
    }

    public TransportOrder create(TransportOrder order) {
        return repository.save(order);
    }

    public List<TransportOrder> findByClient(String client) {
        return repository.findByClient(client);
    }

    public List<TransportOrder> findByStatus(String status) {
        return repository.findByStatus(status);
    }

    public TransportOrder updateOrder(Long id, TransportOrder updatedOrder) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setClient(updatedOrder.getClient());
                    existing.setPlecare(updatedOrder.getPlecare());
                    existing.setDestinatie(updatedOrder.getDestinatie());
                    existing.setDataPlecare(updatedOrder.getDataPlecare());
                    existing.setTipMarfa(updatedOrder.getTipMarfa());
                    existing.setGreutateKg(updatedOrder.getGreutateKg());
                    existing.setSofer(updatedOrder.getSofer());
                    existing.setStatus(updatedOrder.getStatus());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Comanda nu a fost găsită"));
    }

    public void deleteOrder(Long id) {
        repository.deleteById(id);
    }
}
