package com.kodlamaio.invoiceservice.business.concretes;

import com.kodlamaio.common.utilities.mapping.ModelMapperService;
import com.kodlamaio.invoiceservice.business.abstracts.InvoiceService;
import com.kodlamaio.invoiceservice.business.requests.CreateInvoiceRequest;
import com.kodlamaio.invoiceservice.business.responses.CreateInvoiceResponse;
import com.kodlamaio.invoiceservice.core.utilities.generate.GenerateRandomCode;
import com.kodlamaio.invoiceservice.dataAccess.InvoiceRepository;
import com.kodlamaio.invoiceservice.entities.Invoice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InvoiceManager implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ModelMapperService mOdelMapperService;

    @Override
    public CreateInvoiceResponse add(CreateInvoiceRequest createInvoiceRequest) {
        Invoice invoice = this.mOdelMapperService.forRequest().map(createInvoiceRequest,Invoice.class);
        this.invoiceRepository.save(invoice);

        CreateInvoiceResponse createInvoiceResponse = this.mOdelMapperService.forResponse().map(invoice,CreateInvoiceResponse.class);
        return createInvoiceResponse;
    }

    

    private String generateCode() {
        while (true){
            String code = GenerateRandomCode.generate();
            if(!this.invoiceRepository.existsByInvoiceNo(code)){
                return code;
            }
        }
    }
}
// Merhabalar hocam, ben Ömer Aykaç. İstemiş olduğunuz medium yazısını yazdım ve Linkedinden paylaştım.