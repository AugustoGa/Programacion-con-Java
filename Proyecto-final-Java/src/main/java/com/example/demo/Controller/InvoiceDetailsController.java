package com.example.demo.Controller;


import com.example.demo.Entity.InvoiceDetails;
import com.example.demo.Service.InvoiceDetailsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class InvoiceDetailsController {

    @Autowired
    private InvoiceDetailsService invoiceDetailsService;

    @Operation(summary = "Get all invoice details", description = "Get all invoice details", tags = {
            "Invoice Details" })
    @GetMapping(value = "/", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice details retrieved successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Invoice details not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")

    })
    public ResponseEntity<List<InvoiceDetails>> getInvoiceDetails(){
        List<InvoiceDetails> invoiceDetails = invoiceDetailsService.getInvoiceDetails();
        return ResponseEntity.ok(invoiceDetails);
    }


    @Operation(summary = "Get invoice details by id", description = "Get invoice details by id", tags = {
            "Invoice Details" })
    @GetMapping(value = "/invoiceDetails/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice details found"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "404", description = "Invoice details not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<InvoiceDetails> getInvoiceDetailsById(@PathVariable Long id) throws Exception{
        InvoiceDetails invoiceDetails = invoiceDetailsService.getInvoiceDetailsById(id);
        return ResponseEntity.ok(invoiceDetails);
    }

    @Operation(summary = "Create Invoice Details", description = "Creates an invoice details.", tags = {
            "Invoice" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/InvoiceDetails")
    public ResponseEntity<InvoiceDetails> postInvoiceDetails(@RequestBody InvoiceDetails invoiceDetails) throws Exception{
        invoiceDetailsService.CreatedInvoiceDetails(invoiceDetails);
        return ResponseEntity.ok(invoiceDetails);
    }

    @Operation(summary = "Delete Invoice Details with Details", description = "Delets an invoice.", tags = {
            "Invoice" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice Delete successfully"),
            @ApiResponse(responseCode = "400", description = "Bad Request")
    })
    @PostMapping("/InvoiceDetails/{id}")
    public void deleteInvoiceDetails(@PathVariable Long id) throws Exception{
        invoiceDetailsService.deleteInvoiceDetailsById(id);
    }
}
