import java.util.Scanner;

public class Menu {
    public static void mostrarMenu() {
        System.out.println("\n=================================");
        System.out.println("      MARTA PELUQUERIA - CLI     ");
        System.out.println("=================================");
        System.out.println("1. Agendar una reserva");
        System.out.println("2. Listar todas las reservas del dia");
        System.out.println("3. Cancelar una reserva");
        System.out.println("4. Ver el reporte del dia");
        System.out.println("5. Salir del programa");
    }

    public static int leerOpcion(Scanner sc) {
        return Validador.leerEntero(sc, "Elija una opcion (1-5): ");
    }
}