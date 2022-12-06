package com.kodlamaio.invoiceservice.api.controller;

import com.kodlamaio.common.utilities.result.DataResult;
import com.kodlamaio.common.utilities.result.Result;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.responses.GetAllInvoiceResponse;
import com.kodlamaio.invoiceservice.business.responses.GetInvoiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping("/getAll")
   public DataResult<List<GetAllInvoiceResponse>> getAll()  {
        return this.invoiceService.getAll();
    }
    @GetMapping("/getById/{id}")
   public DataResult<GetInvoiceResponse> getById(@PathVariable String id)  {
        return this.invoiceService.getById(id);
    }
    @DeleteMapping("/delete/{id}")
   public Result delete(@PathVariable String id)  {
        return this.invoiceService.delete(id);
    }
}
