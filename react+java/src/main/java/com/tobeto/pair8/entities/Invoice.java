package com.tobeto.pair8.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "rental_id")
    private Rental rental;



}
