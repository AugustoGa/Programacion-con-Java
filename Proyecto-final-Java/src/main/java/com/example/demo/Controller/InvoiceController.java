package com.example.demo.Controller;



import com.example.demo.Entity.Invoice;
import com.example.demo.Service.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    @Operation(summary = "Get all invoices", description = "Get all invoices", tags = { "Invoice" })
    @GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoices retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Not Found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Invoice>> getInvoice(){
        List<Invoice> invoices = invoiceService.getInvoice();
        return ResponseEntity.ok(invoices);
    }


    @Operation(summary = "Get invoice by id", description = "Get invoice by id", tags = { "Invoice" })
    @GetMapping(value = "/invoice/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Invoice not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) throws Exception{
        Invoice invoice = invoiceService.getInvoiceById(id);
        return ResponseEntity.ok(invoice);
    }

    @Operation(summary = "Create Invoice with Details", description = "Creates an invoice with client and details.", tags = {
            "Invoice" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/invoice")
    public ResponseEntity<Invoice> postInvoice(@RequestBody Invoice invoice){
        invoiceService.CreatedInvoice(invoice);
        return  ResponseEntity.ok(invoice);
    }

    @Operation(summary = "Delete Invoice with Details", description = "Delets an invoice with client and details.", tags = {
            "Invoice" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice Delete successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/invoice/{id}")
    public void deleteInvoice(@PathVariable Long id) throws Exception{
        invoiceService.deleteInvoiceById(id);
    }
}
