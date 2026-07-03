import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
int edad;
double salario;
float promedio;
char sexo;
boolean estado;
String nombre;
//entrada de datos por ventana emergente
nombre = JOptionPane.showInputDialog("Digite el nombre del estudiante: ");
edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad del estudiante: "));
salario = Double.parseDouble(JOptionPane.showInputDialog("Digite el salario del estudiante: "));
promedio = Float.parseFloat(JOptionPane.showInputDialog("Digite el promedio del estudiante: "));
sexo = JOptionPane.showInputDialog("Digite el sexo del estudiante: ").charAt(0);
estado = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite el estado del estudiante: "   ));

//salida de datos por ventana emergente
JOptionPane.showMessageDialog(null, "El nombre del estudiante es: " + nombre);






    }
}
