package com.kodlamaio.invoiceservice.dataAccess;

import com.kodlamaio.invoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,String> {

    Boolean existsByInvoiceNo (String code);
}
