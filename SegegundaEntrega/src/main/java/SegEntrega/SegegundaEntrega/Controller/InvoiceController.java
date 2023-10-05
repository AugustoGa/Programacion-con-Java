package SegEntrega.SegegundaEntrega.Controller;


import SegEntrega.SegegundaEntrega.Entity.Invoice;
import SegEntrega.SegegundaEntrega.Service.InvoiceService;
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
        List<Invoice> invoice = invoiceService.getInvoice();
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/invoice/{id}")
    public ResponseEntity<Invoice>getInvoiceById(@PathVariable Integer id) throws Exception{
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice")
    public ResponseEntity<Invoice>postInvoice(@RequestBody Invoice invoice){
        invoiceService.createdInvoice(invoice);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/invoice/{id}")
    public void deleteInvoice(@PathVariable Integer id) throws Exception{
        invoiceService.deleteInvoiceById(id);
    }
}
