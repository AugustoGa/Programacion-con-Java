import java.util.Scanner;

public class numeroMes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INGRESE EL NUMERO DE MES");
        int NumeroMes = scanner.nextInt();
        String nombreMes;
        if (NumeroMes == 0 ) {
            System.out.println("No se puede ingresar numero de mes 0");
        }else {
        switch (NumeroMes){
                case 1 : nombreMes = "Enero";
                break;
                case 2 : nombreMes = "Febrero";
                break;
                case 3 : nombreMes = "Marzo";
                break;
                case 4 : nombreMes = "Abril";
                break;
                case 5 : nombreMes = "Mayo";
                break;
                case 6 : nombreMes = "Junio";
                break;
                case 7 : nombreMes = "Julio";
                break;
                case 8 : nombreMes = "Agosto";
                break;
                case 9 : nombreMes = "Septiembre";
                break;
                case 10 : nombreMes = "Octubre";
                break;
                case 11 : nombreMes = "Noviembre";
                break;
                case 12 : nombreMes = "Diciembre";
                break;
                default: nombreMes = "invalido";
                    break;
            }
            System.out.println("nombre de mes " + nombreMes);
        }
    }
}
