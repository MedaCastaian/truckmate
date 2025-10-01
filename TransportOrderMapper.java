package com.truckmate.truckmate.mapper;

import com.truckmate.truckmate.dto.TransportOrderDTO;
import com.truckmate.truckmate.dto.TransportOrderRequestDTO;
import com.truckmate.truckmate.entity.TransportOrder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransportOrderMapper {

    TransportOrderDTO toDTO(TransportOrder entity);

    TransportOrder toEntity(TransportOrderRequestDTO dto);

    List<TransportOrderDTO> toDTOList(List<TransportOrder> entityList);
}
