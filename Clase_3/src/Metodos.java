public class Metodos {
    public static void main(String[] args) {
        double propina = CalcularPropina(8000  , 10);
        System.out.println("Propina: "+ propina);

    }
    public static double CalcularPropina (double Subtotal, double porcentaje){
        return porcentaje * Subtotal;
    }
    public static double CalcularTotal (double Subtotal, double porcentaje){
        double propina = CalcularPropina(Subtotal, porcentaje);
        return Subtotal + propina;
    }
}
