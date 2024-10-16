package docencia.xaviersastre.dam.psp.ut01;

import java.io.*;
public class UT1Exercici03 {
    public static void main(String args[]) {
        String line;
        try {
            Process hijo = new ProcessBuilder("./mayusculas").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            PrintStream ps = new PrintStream(hijo.getOutputStream());
            BufferedReader in = new BufferedReader(new
                    InputStreamReader(System.in));
// Para salir del bucle se puede pulsar Ctrl-D // Finaliza la entrada
            while ((line = in.readLine()) != null) {
                ps.println(line);
                ps.flush(); // IMP: Comprueba envío de datos if ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error ocurrió durante la ejecución. Descripción del error: " + e.getMessage());
        }
    }
}
