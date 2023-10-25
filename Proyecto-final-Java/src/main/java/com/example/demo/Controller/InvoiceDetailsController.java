package com.example.demo.Controller;


import com.example.demo.Entity.InvoiceDetails;
import com.example.demo.Service.InvoiceDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class InvoiceDetailsController {

    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    public ResponseEntity<List<InvoiceDetails>> getInvoiceDetails(){
        List<InvoiceDetails> invoiceDetails = invoiceDetailsService.getInvoiceDetails();
        return ResponseEntity.ok(invoiceDetails);
    }

    @GetMapping("/invoiceDetails/{id}")
    public ResponseEntity<InvoiceDetails> getInvoiceDetailsById(@PathVariable Long id) throws Exception{
        InvoiceDetails invoiceDetails = invoiceDetailsService.getInvoiceDetailsById(id);
        return ResponseEntity.ok(invoiceDetails);
    }

    @PostMapping("/InvoiceDetails")
    public ResponseEntity<InvoiceDetails> postInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) throws Exception{
        invoiceDetailsService.CreatedInvoiceDetails(invoiceDetails);
        return ResponseEntity.ok(invoiceDetails);
    }

    @PostMapping("/InvoiceDetails/{id}")
    public void deleteInvoiceDetails(@PathVariable Long id) throws Exception{
        invoiceDetailsService.deleteInvoiceDetailsById(id);
    }
}
