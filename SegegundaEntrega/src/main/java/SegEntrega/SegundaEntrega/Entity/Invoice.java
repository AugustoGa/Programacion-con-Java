package SegEntrega.SegundaEntrega.Entity;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    private Date createdAt;

    private Double total;

    //Constructor

    public Invoice() {
    }

    public Invoice(Integer id, Client client, Date createdAt, Double total) {
        this.id = id;
        this.client = client;
        this.createdAt = createdAt;
        this.total = total;
    }
    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
