package com.tobeto.pair8.repositories;

import com.tobeto.pair8.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
