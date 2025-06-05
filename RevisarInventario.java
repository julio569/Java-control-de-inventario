package funeado;

import java.util.Scanner;


public class RevisarInventario {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner scanner = new Scanner(System.in);
        int opcion;
                                                               // La interfaz que le aparece al usuario para elegir las opciones sobre lo que desea hacer
        do {
            System.out.println("\n--- Menú de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Revisar stock");
            System.out.println("3. Quitar producto");
            System.out.println("4. Ver errores registrados");
            System.out.println("5. Cerrar programa");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
                                                                           // En el caso para agregar un producto se hace esto
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del modelo a agregar:(ej. Samsung S24 Plus, Iphone 14 PRO MAX, Motorola G4 Plus, Samsung J7 Neo): ");
                    String nombreAgregar = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a agregar: ");
                    int cantidadAgregar = scanner.nextInt();
                    scanner.nextLine();
                    inventario.agregarProducto(nombreAgregar, cantidadAgregar);
                    break;
                case 2:                                                   // En el caso de revisar el stock hace esto
                    inventario.revisarStock();
                    break;
                case 3:                                                     // En el caso de quitar un modelo hace esto
                    System.out.print("Ingrese el nombre del modelo a quitar: (ej. Samsung S24 Plus, Iphone 14 PRO MAX, Motorola G4 Plus, Samsung J7 Neo): ");
                    String nombreQuitar = scanner.nextLine();
                    System.out.print("Ingrese la cantidad a quitar: ");
                    int cantidadQuitar = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        inventario.quitarProducto(nombreQuitar, cantidadQuitar);
                    } catch (StockInsuficienteException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:                                                 // En el caso de querer ver los errores registrados hace esto
                    System.out.println("\n--- Errores Registrados ---");
                    RegistroLog.mostrarErroresDesdeArchivo();
                    break;
                case 5:                                                // Opcion para cerrrar el programa
                    System.out.println("Se está cerrando el programa...");
                    break;
                default:                                               // Opcion por default si el usauario no ingresa el numero para elegir lo que desea hacer
                    System.out.println("La opción no es válida. Por favor, seleccione una de las opciones del menú.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}
