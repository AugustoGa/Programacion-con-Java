package edu.CoderHouse.Entregable1.Model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "client_id")
    @OneToMany
    private Client client;

    @Column(name = "created_at")
    private Date createdAt;

    private Double total;

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    //Constructor

    public Invoice(int id, Client client, Date createdAt, Double total) {
        this.id = id;
        this.client = client;
        this.createdAt = createdAt;
        this.total = total;
    }
}
