package edu.CoderHouse.Entregable1.Model;


import javax.persistence.*;


//@Entity es una anotación que define el componente y que especifica que una clase es una entidad.
;

//@Table especifica el origen de datos que se debe utilizar en la clase.
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    // @Column Hace referencia a la columna lastname en tables.sql
    @Column(name = "lastname")
    private String lastname;

    @Column(name = "doc_number")
    private String docnumber;



    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }

    //Constructor
    public Client() {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.docnumber = docnumber;
    }

    //Met toString
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                '}';
    }
}
