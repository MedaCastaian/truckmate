package com.truckmate.truckmate.mapper;

import com.truckmate.truckmate.dto.TransportOrderDTO;
import com.truckmate.truckmate.dto.TransportOrderRequestDTO;
import com.truckmate.truckmate.entity.TransportOrder;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-15T17:31:13+0300",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250628-1110, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class TransportOrderMapperImpl implements TransportOrderMapper {

    @Override
    public TransportOrderDTO toDTO(TransportOrder entity) {
        if ( entity == null ) {
            return null;
        }

        TransportOrderDTO transportOrderDTO = new TransportOrderDTO();

        transportOrderDTO.setClient( entity.getClient() );
        transportOrderDTO.setDataPlecare( entity.getDataPlecare() );
        transportOrderDTO.setDestinatie( entity.getDestinatie() );
        transportOrderDTO.setGreutateKg( (int) entity.getGreutateKg() );
        transportOrderDTO.setPlecare( entity.getPlecare() );
        transportOrderDTO.setSofer( entity.getSofer() );
        transportOrderDTO.setStatus( entity.getStatus() );
        transportOrderDTO.setTipMarfa( entity.getTipMarfa() );

        return transportOrderDTO;
    }

    @Override
    public TransportOrder toEntity(TransportOrderRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TransportOrder.TransportOrderBuilder transportOrder = TransportOrder.builder();

        transportOrder.client( dto.getClient() );
        transportOrder.dataPlecare( dto.getDataPlecare() );
        transportOrder.destinatie( dto.getDestinatie() );
        transportOrder.greutateKg( dto.getGreutateKg() );
        transportOrder.plecare( dto.getPlecare() );
        transportOrder.sofer( dto.getSofer() );
        transportOrder.status( dto.getStatus() );
        transportOrder.tipMarfa( dto.getTipMarfa() );

        return transportOrder.build();
    }

    @Override
    public List<TransportOrderDTO> toDTOList(List<TransportOrder> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TransportOrderDTO> list = new ArrayList<TransportOrderDTO>( entityList.size() );
        for ( TransportOrder transportOrder : entityList ) {
            list.add( toDTO( transportOrder ) );
        }

        return list;
    }
}
