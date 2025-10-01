package com.truckmate.truckmate.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "transport_orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Clientul este obligatoriu")
    private String client;

    @NotBlank(message = "Locul de plecare este obligatoriu")
    private String plecare;

    @NotBlank(message = "Destinația este obligatorie")
    private String destinatie;

    @Future(message = "Data plecării trebuie să fie în viitor")
    @Column(name = "data_plecare")
    private LocalDate dataPlecare;

    @NotBlank(message = "Tipul mărfii este obligatoriu")
    @Column(name = "tip_marfa")
    private String tipMarfa;

    @Min(value = 1, message = "Greutatea trebuie să fie mai mare ca 0")
    @Column(name = "greutate_kg")
    private double greutateKg;

    @NotBlank(message = "Șoferul este obligatoriu")
    private String sofer;

    @NotBlank(message = "Statusul este obligatoriu")
    private String status;
}

