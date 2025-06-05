package funeado;

import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;
                                                      // La Inicializacion del inventario con los productos por defecto
    public Inventario() {
        this.productos = new ArrayList<>();
        inicializarInventario();
    }

    private void inicializarInventario() {
        productos.add(new Producto("Samsung S24 Plus", 14, 999.999));
        productos.add(new Producto("Iphone 14 PRO MAX", 16, 999.999));
        productos.add(new Producto("Motorola G4 Plus", 24, 300.000));
        productos.add(new Producto("Samsung J7 Neo", 21, 150.000));
    }
                                                                  // Este es el metodo para agregar cualquier producto al inventario
    public void agregarProducto(String nombre, int cantidad) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                producto.setCantidad(producto.getCantidad() + cantidad);
                System.out.println("Producto actualizado: " + nombre + " | Nueva cantidad: " + producto.getCantidad());
                return;
            }
        }                                                                  // Esto es por si no se ingresa el modelo que pertenece al stock
        String mensajeError = "El modelo ingresado no pertenece al stock: " + nombre;
        System.out.println("Error: " + mensajeError);
        RegistroLog.escribirErrorEnArchivo(mensajeError);
    }
                                                                        // Este es el metodo para quitar un producto del stock
    public void quitarProducto(String nombre, int cantidad) throws StockInsuficienteException {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                int nuevaCantidad = producto.getCantidad() - cantidad;
                if (nuevaCantidad >= 0) {
                    producto.setCantidad(nuevaCantidad);
                    System.out.println("Producto actualizado: " + nombre + " | Cantidad restante: " + nuevaCantidad);
                } else {
                    String mensajeError = "Quitaste más de lo que hay en stock: " + nombre;
                    RegistroLog.escribirErrorEnArchivo(mensajeError);
                    throw new StockInsuficienteException("Error: " + mensajeError);
                }
                return;
            }
        }
        String mensajeError = "Producto no encontrado en el inventario: " + nombre;
        System.out.println("Error: " + mensajeError);
        RegistroLog.escribirErrorEnArchivo(mensajeError);
    }
                                                                       // Metodo para revisar el stock
    public void revisarStock() {
        System.out.println("\n--- Stock Actual ---");
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
        } else {
            for (Producto producto : productos) {
                producto.mostrarInfo();
            }
        }
    }
}
