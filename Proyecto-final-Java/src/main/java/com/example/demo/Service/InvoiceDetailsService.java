package com.example.demo.Service;


import com.example.demo.Entity.InvoiceDetails;
import com.example.demo.Repository.InvoiceDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceDetailsService {

    @Autowired
    private InvoiceDetailsRepository invoiceDetailsRepository;

    public void CreatedInvoiceDetails(InvoiceDetails invoiceDetails){
        invoiceDetailsRepository.save(invoiceDetails);
    }

    public List<InvoiceDetails> getInvoiceDetails(){
        return invoiceDetailsRepository.findAll();
    }

    public InvoiceDetails getInvoiceDetailsById(Long id) throws Exception{
        Optional<InvoiceDetails> invoiceDetails = invoiceDetailsRepository.findById(id);
        if (invoiceDetails.isPresent()){
            return invoiceDetails.get();
        }else {
            throw new Exception("Invoice Detail not exist");
        }
    }

    public void deleteInvoiceDetailsById(Long id) throws Exception{
        InvoiceDetails invoiceDetails = getInvoiceDetailsById(id);
        invoiceDetailsRepository.delete(invoiceDetails);
    }
}
