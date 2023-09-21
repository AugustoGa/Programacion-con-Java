package edu.CoderHouse.Entregable1.Model;




//@Entity es una anotación que define el componente y que especifica que una clase es una entidad.
;import javax.persistence.*;

//@Table especifica el origen de datos que se debe utilizar en la clase.
@Entity
@Table(name = "products")
public class Products {
    //IDENTITY. Se basa en una columna de base de datos con incremento automático y permite
    // que la base de datos genere un nuevo valor con cada operación de inserción
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private String code;

    private int stock;

    private double price;


    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Constructor
    public Products() {
        this.id = id;
        this.description = description;
        this.code = code;
        this.stock = stock;
        this.price = price;
    }


    //Met toString
    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
