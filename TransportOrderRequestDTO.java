package com.truckmate.truckmate.dto;

import lombok.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransportOrderRequestDTO {

    @NotBlank(message = "Clientul este obligatoriu")
    private String client;

    @NotBlank(message = "Locul de plecare este obligatoriu")
    private String plecare;

    @NotBlank(message = "Destinația este obligatorie")
    private String destinatie;

    @Future(message = "Data plecării trebuie să fie în viitor")
    private LocalDate dataPlecare;

    @NotBlank(message = "Tipul mărfii este obligatoriu")
    private String tipMarfa;

    @Min(value = 1, message = "Greutatea trebuie să fie mai mare ca 0")
    private double greutateKg;

    @NotBlank(message = "Șoferul este obligatoriu")
    private String sofer;

    @NotBlank(message = "Statusul este obligatoriu")
    private String status;
}
