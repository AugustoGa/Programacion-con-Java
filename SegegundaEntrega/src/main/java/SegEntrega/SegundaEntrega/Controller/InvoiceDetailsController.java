package SegEntrega.SegundaEntrega.Controller;


import SegEntrega.SegundaEntrega.Entity.InvoiceDetails;
import SegEntrega.SegundaEntrega.Service.InvoiceDetailsService;
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
    public ResponseEntity<InvoiceDetails>getInvoiceDetailsById(@PathVariable Integer id) throws Exception{
        InvoiceDetails invoiceDetails = invoiceDetailsService.getInvoiceDetailsById(id);
        return ResponseEntity.ok(invoiceDetails);
    }

    @PostMapping("/InvoiceDetails")
    public ResponseEntity<InvoiceDetails>postInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails){
        invoiceDetailsService.createdInvoiceDetails(invoiceDetails);
        return ResponseEntity.ok(invoiceDetails);
    }

    @PostMapping("/invoiceDetails/{id}")
    public void deleteInvoiceDetails(@PathVariable Integer id) throws Exception{
        invoiceDetailsService.deleteInvoiceDetailById(id);
    }
}
