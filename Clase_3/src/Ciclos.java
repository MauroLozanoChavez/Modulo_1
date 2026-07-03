import java.util.Scanner;
public class Ciclos {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Plato # " + i+ " impreso en el recibo");
        }
        System.out.println("--------------------------------------------------");
        int mesasPorLimpiar = 3;
        while (mesasPorLimpiar > 0) {
        System.out.println("Faltan " + mesasPorLimpiar + " mesas por limpiar");
        mesasPorLimpiar--;
        }
System.out.println("Todo limpio!");
System.out.println("--------------------------------------------------");

Scanner sc = new Scanner(System.in);
int opcion;
int contador = 0;
do {
    System.out.println("1. continuar   2. salir");
    System.out.println("Elige: ");
    opcion = sc.nextInt();
    contador++;
} while (opcion != 2);
System.out.println("usted ingreso " + contador + " veces la opcion 1");
System.out.println("--------------------------------------------------");
    }
}




