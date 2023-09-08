import java.util.ArrayList;

public class ListarPersonas {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Augusto", "Gallo");
        Persona persona2 = new Persona("Mili", "Cabrera");
        Persona persona3 = new Persona("Male", "Ccock");
        Persona persona4 = new Persona("Julio", "Baque");
        Persona persona5 = new Persona("Mauri", "Romero");


        //ArrayList
        ArrayList<Persona> PersonasArrays = new ArrayList<>();
        PersonasArrays.add(persona1);
        PersonasArrays.add(persona2);
        PersonasArrays.add(persona3);
        PersonasArrays.add(persona4);
        PersonasArrays.add(persona5);



        for(Persona PersonasArray : PersonasArrays){
            System.out.println("ORDEN ORIGINAL");
            System.out.println(PersonasArray);
        }

        System.out.println("--------------------------------------");

        PersonasArrays.sort((p1,p2)-> p1.getApellido().compareTo(p2.getApellido()));
        PersonasArrays.sort((p1,p2)-> p1.getNombre().compareTo(p2.getNombre()));
        for(Persona PersonasArray : PersonasArrays){
            System.out.println("ORDENADO POR NOMBRE");
            System.out.println(PersonasArray);
        }

        System.out.println("--------------------------------------");

        PersonasArrays.sort((p1,p2)-> p2.getApellido().compareTo(p1.getApellido()));
        PersonasArrays.sort((p1,p2)-> p2.getNombre().compareTo(p1.getNombre()));
        for(Persona PersonasArray : PersonasArrays){
            System.out.println("ORDENADO A LA INVERZA POR NOMBRE");
            System.out.println(PersonasArray);
        }

        System.out.println("--------------------------------------");

        PersonasArrays.sort((p1,p2)-> p1.getNombre().compareTo(p2.getNombre()));
        PersonasArrays.sort((p1,p2)-> p1.getApellido().compareTo(p2.getApellido()));
        for(Persona PersonasArray : PersonasArrays){
            System.out.println("ORDENADO POR APELLIDO");
            System.out.println(PersonasArray);
        }

        System.out.println("--------------------------------------");

        PersonasArrays.sort((p1,p2)-> p2.getNombre().compareTo(p1.getNombre()));
        PersonasArrays.sort((p1,p2)-> p2.getApellido().compareTo(p1.getApellido()));
        for(Persona PersonasArray : PersonasArrays){
            System.out.println("ORDENADO A LA INVERZA POR APELLIDO");
            System.out.println(PersonasArray);
        }
    }
}
