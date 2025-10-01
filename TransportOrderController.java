package com.truckmate.truckmate.controller;

import com.truckmate.truckmate.dto.TransportOrderDTO;
import com.truckmate.truckmate.dto.TransportOrderRequestDTO;
import com.truckmate.truckmate.entity.TransportOrder;
import com.truckmate.truckmate.mapper.TransportOrderMapper;
import com.truckmate.truckmate.service.TransportOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class TransportOrderController {

    private final TransportOrderService service;
    private final TransportOrderMapper mapper;

    @GetMapping
    public List<TransportOrderDTO> getAll() {
        return service.getAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/client")
    public List<TransportOrderDTO> getByClient(@RequestParam String client) {
        return service.findByClient(client).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/status")
    public List<TransportOrderDTO> getByStatus(@RequestParam String status) {
        return service.findByStatus(status).stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<TransportOrderDTO> create(@Valid @RequestBody TransportOrderRequestDTO dto) {
        TransportOrder order = mapper.toEntity(dto);
        TransportOrder saved = service.create(order);
        return new ResponseEntity<>(mapper.toDto(saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public TransportOrderDTO update(@PathVariable Long id, @Valid @RequestBody TransportOrderDTO dto) {
        TransportOrder updated = service.updateOrder(id, mapper.toEntity(dto));
        return mapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
