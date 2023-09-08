import java.util.Objects;

public class Persona {
    //iniciaremos declarando sus atributos, es muy común que los atributos se declaren como privados,
    // ya que se utilizan para las operaciones de los métodos dentro de la misma clase,
    // así que en este caso los atributos serán privados.
     private String nombre ;
     private String apellido ;



     //Constructor vacio (permite crear objetos con “new Clase()”
     // sin argumentos, aunque no se defina ningún constructor.)
    public Persona() {
    }

    //Constructor con parametros
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    //Getters and setters
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
    //toString
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Persona persona = (Persona) o;

        if (!Objects.equals(nombre, persona.nombre)) return false;
        return Objects.equals(apellido, persona.apellido);
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        return result;
    }
}
