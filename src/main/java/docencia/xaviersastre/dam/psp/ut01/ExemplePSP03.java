package docencia.xaviersastre.dam.psp.ut01;

import java.io.*;
public class ExemplePSP03 {
    public static void main(String args[]) { String line;
        try{
            Process fill = new
                ProcessBuilder("U1/nopublicatsencara/UT1Exercici03_c").start();
                BufferedReader br = new BufferedReader(new InputStreamReader(fill.getInputStream()));
                PrintStream ps = new PrintStream(fill.getOutputStream());
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                // Per sortir del bucle haurem de interrompre el procés
                // Finaliza la entrada
                while ((line = in.readLine()) != null) {
                    ps.println(line);
                    ps.flush(); // Important fa que les dades efectivament s'enviin
                    if ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
                }
        System.out.println("Finalizando");
        } catch (IOException e) {
            System.out.println("Error ocurrió durante la ejecución. " +
                    "Descripción del error: " + e.getMessage());
        }
    }
}
        