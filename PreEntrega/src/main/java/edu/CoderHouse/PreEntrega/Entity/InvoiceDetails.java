package edu.CoderHouse.PreEntrega.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Invoice invoice;

    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "product_id") // Puedes usar @JoinColumn para especificar la columna
    private Product product;

    private Double price;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Integer id, Invoice invoice, Integer amount, Product product, Double price) {
        this.id = id;
        this.invoice = invoice;
        this.amount = amount;
        this.product = product;
        this.price = price;
    }

    // Getters y setters
}

