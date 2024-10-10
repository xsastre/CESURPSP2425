package docencia.xaviersastre.dam.psp.ut01;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Processos04 {

    public static void main(String[] args) {
        try {
            // Otra forma de llamar a Processos es usando Desktop,
            // lanza la aplicacion predeterminada en el sistema
            Desktop d = null;
            d = Desktop.getDesktop();
            d.browse(new URI("http://www.google.es"));
        } catch (URISyntaxException ex) {
            System.err.println("Error la lanzar URI");
        } catch (IOException ex) {
            System.err.println("Error la lanzar Proceso Desktop");
        }
    }
}
