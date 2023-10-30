package com.example.demo.Service;


import com.example.demo.Entity.Client;
import com.example.demo.Entity.Invoice;
import com.example.demo.Entity.InvoiceDetails;
import com.example.demo.Repository.InvoiceRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

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

    public Invoice saveWithDetails(Invoice invoice) {
        Long clientId = invoice.getClient().getId();
        Optional<Client> clientOptional = clientService.getClientById(clientId);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://worldclockapi.com/api/json/utc/now",
                String.class);

        Date currentDate;

        if (response.getStatusCode().is2xxSuccessful()) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                JsonNode root = objectMapper.readTree(response.getBody());
                String currentDateString = root.get("currentDateTime").asText();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                currentDate = simpleDateFormat.parse(currentDateString);

                // Convert java.util.Date to java.sql.Date
                java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

                invoice.setCreatedAt(sqlDate);
            } catch (Exception e) {
                currentDate = new Date();
            }
        } else {
            currentDate = new Date();
        }
        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        invoice.setCreatedAt(sqlDate);
        if (clientOptional.isEmpty())
            throw new RuntimeException("The client not exists");

        Client client = clientOptional.get();
        invoice.setClient(client);

        int totalProduct = 0;
        var details = invoice.getInvoiceDetail();
        var aux = 0d;
        if (details != null)
            for (InvoiceDetails id : details) {
                Long productId = id.getProduct().getProductId();
                Long amount = id.getAmount();

                var newStockWithSell = productService.updateStockWithSell(productId, amount);
                if (newStockWithSell < 0)
                    throw new RuntimeException("There is not enough stock for the product with ID " + productId);

                id.getProduct().setStock(newStockWithSell);

                id.setPrice(productService.getProductPrice(id.getProduct().getProductById()) * id.getAmount());
                aux += id.getPrice();
                totalProduct += amount;
            }
        invoice.setTotalProduct(totalProduct);
        invoice.setTotal(aux);

        return save(invoice);
    }
}
