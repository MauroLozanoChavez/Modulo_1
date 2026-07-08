import java.util.Scanner;

public class Operaciones {
    static final int MAX_RESERVAS = 10;
    static String[] clientes = new String[MAX_RESERVAS];
    static int[] horas = new int[MAX_RESERVAS];
    static int[] servicios = new int[MAX_RESERVAS];
    static int contadorReservas = 0;
    static final int PRECIO_CORTE = 25000;
    static final int PRECIO_TINTE = 60000;
    static final int PRECIO_MANICURE = 30000;

    //No me gusta que la lista de reservas se vea desordenada, asi que la ordeno por hora para que se vea mejor
    public static void ordenarPorHora() {
        for (int i = 0; i < contadorReservas - 1; i++) {
            for (int j = 0; j < contadorReservas - i - 1; j++) {
                if (horas[j] > horas[j + 1]) {
                    // Intercambiamos las horas
                    int tempHora = horas[j];
                    horas[j] = horas[j + 1];
                    horas[j + 1] = tempHora;

                    // Intercambiamos los clientes
                    String tempCliente = clientes[j];
                    clientes[j] = clientes[j + 1];
                    clientes[j + 1] = tempCliente;

                    // Intercambiamos los servicios
                    int tempServicio = servicios[j];
                    servicios[j] = servicios[j + 1];
                    servicios[j + 1] = tempServicio;
                }
            }
        }
    }

    // Busca en las horas guardadas para ver si alguien mas ya aparto ese espacio
    public static boolean horaOcupada(int hora) {
        for (int i = 0; i < contadorReservas; i++) {
            if (horas[i] == hora) {
                return true;
            }
        }
        return false;
    }

    // Pasa el numero del servicio a palabras para mostrarlo
    public static String obtenerNombreServicio(int codigo) {
        switch (codigo) {
            case 1: return "Corte de cabello";
            case 2: return "Tinte";
            case 3: return "Manicure";
            default: return "Desconocido";
        }
    }

    // Asocia el numero del servicio con su precio para poder sumarlos
    public static int obtenerPrecioServicio(int codigo) {
        switch (codigo) {
            case 1: return PRECIO_CORTE;
            case 2: return PRECIO_TINTE;
            case 3: return PRECIO_MANICURE;
            default: return 0;
        }
    }

    // Registra una nueva cita en la agenda si hay espacio
    public static void agendar(Scanner sc) {
        if (contadorReservas >= MAX_RESERVAS) {
            System.out.println("\nError: Agenda llena. No hay mas cupos para hoy.");
            return;
        }

        System.out.println("\n--- AGENDAR NUEVA RESERVA ---");
        String nombre;
        do {
            nombre = Validador.leerTexto(sc, "Nombre del cliente: ");
            if (!Validador.nombreValido(nombre)) {
                System.out.println("El nombre no puede estar vacio.");
            }
        } while (!Validador.nombreValido(nombre));

        // Pide la hora y revisa que este libre y en el rango permitido
        int hora;
        while (true) {
            hora = Validador.leerEntero(sc, "Hora de la cita (8 a 17 en punto): ");
            if (!Validador.horaValida(hora)) {
                System.out.println("Horario invalido. Debe ser entre 8 y 17.");
            } else if (horaOcupada(hora)) {
                System.out.println("Esa hora ya esta ocupada por otra reserva.");
            } else {
                break;
            }
        }

        // Muestra las opciones y valida la seleccion del servicio
        int servicio;
        while (true) {
            System.out.println("Servicios: 1. Corte ($25.000) | 2. Tinte ($60.000) | 3. Manicure ($30.000)");
            servicio = Validador.leerEntero(sc, "Seleccione el servicio (1-3): ");
            if (Validador.servicioValido(servicio)) {
                break;
            } else {
                System.out.println("Opcion invalida. El servicio debe ser 1, 2 o 3.");
            }
        }

        // Si todo esta ok, guarda los datos en la posicion actual del contador
        clientes[contadorReservas] = nombre;
        horas[contadorReservas] = hora;
        servicios[contadorReservas] = servicio;
        contadorReservas++;
        ordenarPorHora();
        System.out.println("\nReserva agendada con exito para las " + hora + ":00");
    }

    // Muestra el listado de todas las citasagendadas hasta el momento
    public static void listar() {
        System.out.println("\n--- LISTA DE RESERVAS DEL DIA ---");
        if (contadorReservas == 0) {
            System.out.println("Aun no hay reservas.");
            return;
        }

        for (int i = 0; i < contadorReservas; i++) {
            String nombreServicio = obtenerNombreServicio(servicios[i]);
            System.out.printf("[%d] Cliente: %s | Hora: %d:00 | Servicio: %s\n", 
                    (i + 1), clientes[i], horas[i], nombreServicio);
        }
    }

    // Elimina una cita de la lista y acomoda los datos de los demas para no dejar espacios sin nada
    public static void cancelar(Scanner sc) {
        System.out.println("\n--- CANCELAR UNA RESERVA ---");
        if (contadorReservas == 0) {
            System.out.println("No hay reservas registradas para cancelar.");
            return;
        }

        listar(); // Muestra las citas para saber cual borrar

        int numeroReserva = Validador.leerEntero(scanner, "\nIngrese el numero de reserva a cancelar: ");

        if (numeroReserva < 1 || numeroReserva > contadorReservas) {
            System.out.println("El numero de reserva no existe.");
            return;
        }

        int indiceBorrar = numeroReserva - 1; // Restamos 1 para manejar la posicion real del arreglo
        String clienteCancelado = clientes[indiceBorrar];

        // Mueve hacia la izquierda todos los datos que estaban despues de la cita borrada
        for (int i = indiceBorrar; i < contadorReservas - 1; i++) {
            clientes[i] = clientes[i + 1];
            horas[i] = horas[i + 1];
            servicios[i] = servicios[i + 1];
        }

        // Borra los datos que quedaron duplicados al final del arreglo despues de moverlos
        clientes[contadorReservas - 1] = null;
        horas[contadorReservas - 1] = 0;
        servicios[contadorReservas - 1] = 0;

        contadorReservas--;
        System.out.println("Reserva de " + clienteCancelado + " cancelada exitosamente.");
    }

    // muestra cuantas citas van y suma los precios para el total de dinero
    public static void reporte() {
        System.out.println("\n--- REPORTE DEL DIA ---");
        System.out.println("Total de citas agendadas: " + contadorReservas);

        int dineroFacturado = 0;
        for (int i = 0; i < contadorReservas; i++) {
            dineroFacturado += obtenerPrecioServicio(servicios[i]);
        }

        System.out.println("Dinero facturado en caja: $" + dineroFacturado);
    }
}