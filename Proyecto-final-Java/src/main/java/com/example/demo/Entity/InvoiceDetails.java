package com.example.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "invoiceDetails")
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private Invoice invoice;

    @ManyToMany
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

    private Double total;

    public InvoiceDetails() {
    }

    public InvoiceDetails(Long id, Invoice invoice, Product product, Integer amount, Double total) {
        this.id = id;
        this.invoice = invoice;
        this.product = product;
        this.amount = amount;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
