import java.util.Scanner;
public class Cajero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Subtotal: ");
        double subtotal = sc.nextDouble();

    if (subtotal >= 200000) {
            System.out.println("Descuento VIP (15%)");
        } else if(subtotal >= 100000) {
            System.out.println("Descuento Normal (10%)");
        } else {
            System.out.println("No aplica descuento");
        }
    }    
}