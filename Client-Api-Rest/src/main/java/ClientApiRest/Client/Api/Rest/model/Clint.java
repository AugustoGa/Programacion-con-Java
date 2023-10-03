package ClientApiRest.Client.Api.Rest.model;


import jakarta.persistence.*;


@Entity
@Table(name = "client")
public class Clint {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nombre", nullable = false)
    private String nombre;
    @Column(name="apellido", nullable = false)
    private String apellido;
    @Column(name="fecha_nacimiento", nullable = false)
    private String fechaNacimiento;


    public Clint() {
    }

    public Clint(int id, String nombre, String apellido, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    @Override
    public String toString() {
        return "Clint{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
