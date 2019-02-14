
package cliente;
import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 *
 * @author seran
 */
public class Cliente {

    private String nombre;
    private BufferedReader flujoEntrada;
    private PrintWriter flujoSalida;

    public Cliente(int id, BufferedReader br, PrintWriter pw) {
        nombre = "Cliente_" + id;
        flujoEntrada = br;
        flujoSalida = pw;
    }

    public String getNombre() {
        return nombre;
    }

    public BufferedReader getFlujoEntrada() {
        return flujoEntrada;
    }

    public PrintWriter getFlujoSalida() {
        return flujoSalida;
    }
}
