package com.truckmate.truckmate.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class TransportOrderDTO {

    @NotBlank(message = "Clientul este obligatoriu")
    private String client;

    private String plecare;
    private String destinatie;
    private LocalDate dataPlecare;
    private String tipMarfa;
    private Integer greutateKg;
    private String sofer;
    private String status;
}
