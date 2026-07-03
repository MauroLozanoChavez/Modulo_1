import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    System.out.println("Numero de personas en la mesa:");
    int personas = sc.nextInt();

    sc.nextLine();

    System.out.println("Nombre del cliente:");
    String nombre = sc.nextLine();

    System.out.println("Mesa de "+ nombre + ", "+ personas + " personas");

    //!
    double subtotal = 120000;
    boolean tieneCupon = true;

    boolean aplicaDescuento = tieneCupon && subtotal > 100000;
    System.out.println("Aplica descuento: " + aplicaDescuento);

    //!
    int unidades = 5;
    double ComoDecimal= unidades;
    System.out.println("Implicita: " + ComoDecimal);

    double precio = 19990.75;
    int precioRecortado = (int) precio;
    System.out.println("Explicita: " + precioRecortado);

    }
}
