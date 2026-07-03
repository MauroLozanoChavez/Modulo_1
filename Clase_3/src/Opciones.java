import java.util.Scanner;
public class Opciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n -------Menu de opciones-------");
        System.out.println("1. Nuevo pedido");
        System.out.println("2. Aplicar descuento");
        System.out.println("3. Cerrar caja");
        System.out.println("------------------------------");
        System.out.print("Seleccione una opcion: ");
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Subtotal:");
                double subtotal = sc.nextDouble();
                if (subtotal > 100000){
                    System.out.println("Pedido con descuento");
                }else{
                    System.out.println("Pedido sin descuento");
                }
                break;
            case 2:
                System.out.println("Aplicar descuento");
                break;
            case 3:
                System.out.println("Cerrar caja");
                break;
            default:
                System.out.println("Opcion no valida");
        }
}
}
