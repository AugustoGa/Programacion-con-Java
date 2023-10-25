package com.example.demo.Service;


import com.example.demo.Entity.Invoice;
import com.example.demo.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public void CreatedInvoice(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    public List<Invoice> getInvoice(){
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) throws Exception{
        Optional<Invoice> invoice = invoiceRepository.findById(id);
            if (invoice.isPresent()){
                return invoice.get();
            }else {
                throw new Exception("Invoice not exist");
            }
    }

    public void deleteInvoiceById(Long id) throws Exception{
        Invoice invoice = getInvoiceById(id);
        invoiceRepository.delete(invoice);
    }
}
