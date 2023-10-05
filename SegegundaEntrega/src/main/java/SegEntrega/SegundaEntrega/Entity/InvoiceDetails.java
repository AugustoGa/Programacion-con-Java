package SegEntrega.SegundaEntrega.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "invoiceDetails")
public class InvoiceDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer amount;

    private Double total;

    //Constructor
    public InvoiceDetails() {
    }

    public InvoiceDetails(Integer id, Invoice invoice, Product product, Integer amount, Double total) {
        this.id = id;
        this.invoice = invoice;
        this.product = product;
        this.amount = amount;
        this.total = total;
    }

    //Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
