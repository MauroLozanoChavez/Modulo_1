import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            Menu.mostrarMenu();
            opcion = Menu.leerOpcion(sc);

            switch (opcion) {
                case 1:
                    Operaciones.agendar(sc);
                    break;
                case 2:
                    Operaciones.listar();
                    break;
                case 3:
                    Operaciones.cancelar(sc);
                    break;
                case 4:
                    Operaciones.reporte();
                    break;
                case 5:
                    System.out.println("\nSaliendo exitosamente... ¡Excelente jornada, Doña Marta!");
                    break;
                default:
                    System.out.println("Opcion invalida. Ingrese un numero del 1 al 5.");
                    break;
            }
        } while (opcion != 5);

    }
}