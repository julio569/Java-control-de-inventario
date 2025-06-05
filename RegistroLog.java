package funeado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroLog {
    public static void escribirErrorEnArchivo(String mensaje) {
        String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        String mensajeCompleto = "Error: " + mensaje + " | Fecha: " + fecha;

        try (FileWriter grabar = new FileWriter("errores.txt", true)) {
            grabar.write(mensajeCompleto + "\n");
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    public static void mostrarErroresDesdeArchivo() {
        try (BufferedReader lector = new BufferedReader(new FileReader("errores.txt"))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}
