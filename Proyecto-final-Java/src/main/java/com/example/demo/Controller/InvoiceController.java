package com.example.demo.Controller;



import com.example.demo.Entity.Invoice;
import com.example.demo.Service.InvoiceService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    public ResponseEntity<List<Invoice>> getInvoice(){
        List<Invoice> invoices = invoiceService.getInvoice();
        return ResponseEntity.ok(invoices);
    }


    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) throws Exception{
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice> postInvoice(@RequestBody Invoice invoice){
        invoiceService.CreatedInvoice(invoice);
        return  ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice/{id}")
    public void deleteInvoice(@PathVariable Long id) throws Exception{
        invoiceService.deleteInvoiceById(id);
    }
}
