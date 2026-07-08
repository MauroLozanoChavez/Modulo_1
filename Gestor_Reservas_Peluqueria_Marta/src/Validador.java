import java.util.Scanner;

public class Validador {

    // Captura un numero entero y no deja avanzar hasta que sea un dato valido
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextInt()) {
                int valor = sc.nextInt();
                sc.nextLine();
                return valor;
            } else {
                System.out.println("Eso no es un numero entero. Intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    // Recibe el texto que escribe el usuario
    public static String leerTexto(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    // Revisa que la hora este dentro de la jornada (8 am a 5 pm)
    public static boolean horaValida(int hora) {
        return hora >= 8 && hora <= 17;
    }

    // Revisa que el cliente si tenga un nombre real y no puros espacios en blanco
    public static boolean nombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    // Confirma que el servicio este dentro de las 3 opciones que ofrece la peluqueria
    public static boolean servicioValido(int servicio) {
        return servicio == 1 || servicio == 2 || servicio == 3;
    }
}