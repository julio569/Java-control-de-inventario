package funeado;

public class Producto implements ProductoBase {
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String nombre, int cantidad, double precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Producto: " + nombre + ", Cantidad: " + cantidad + ", Precio: $" + precio);
    }
}
