public class Condicionales {
    public static void main(String[] args) {
        double cuenta1 = 50000;
        if (cuenta1 > 100000) {
            System.out.println("Aplica descuento");
        }
        double cuenta2 = 150000;
        if (cuenta2 >= 200000) {
            System.out.println("Descuento VIP (15%)");
        } else if(cuenta2 >= 100000) {
            System.out.println("Descuento Normal (10%)");
        } else {
            System.out.println("No aplica descuento");
        }
    }
}
