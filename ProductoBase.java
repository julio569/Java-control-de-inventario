package funeado;



public interface ProductoBase {
    String getNombre();
    int getCantidad();
    double getPrecio();
    void setCantidad(int cantidad);
    void mostrarInfo();
}
