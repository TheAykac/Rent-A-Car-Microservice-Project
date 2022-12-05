package com.kodlamaio.invoiceservice.api.controller;

import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;
}
