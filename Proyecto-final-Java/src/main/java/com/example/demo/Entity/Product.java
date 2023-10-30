package com.example.demo.Entity;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private Long id;

    @Schema(hidden = true)
    private String description;

    @Schema(hidden = true)
    private String code;

    @Schema(hidden = true)
    private Integer stock;

    @Schema(hidden = true)
    private Double total;

    public Product() {
    }

    public Product(Long id, String description, String code, Integer stock, Double total) {
        this.id = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
