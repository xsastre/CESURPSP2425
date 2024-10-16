package docencia.xaviersastre.dam.psp.ut01;

import java.io.File;
import java.io.IOException;
public class ExemplePSP02 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pBuilder = new ProcessBuilder("U1/ExemplePSP02_c");
            // Modificar el path de la línia següent pel path complet allà on hagueu clonat el repositori
            pBuilder.directory(new File("/Users/xavier/JetBrains/CESURDAMPSP2324"));
            Process process = pBuilder.start();
            int valorRetorn = process.waitFor();
            if (valorRetorn==0) {
                System.out.println("El procés ha acabat correctament");
            } else {
                System.out.println("El procés ha fallat. Codi d'error:"+valorRetorn);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
