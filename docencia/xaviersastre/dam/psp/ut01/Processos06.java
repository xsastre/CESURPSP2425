package docencia.xaviersastre.dam.psp.ut01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Processos06 {

    public static void main(String[] args) {
        try {
            // Leyendo la salida de un proceso
            Process p = Runtime.getRuntime().exec("ls -lt /home/xavier");
            //Process p = Runtime.getRuntime().exec("cmd /c \"dir\"");
            // Pero no vemos la salida. Vamos a leer la salida. OJO que la salida va por el INPUT
            // Returns the input stream connected to the normal output of the process.
            // es decir la entrada de mi programa java se conecta con la salida del proceso
            InputStream in = p.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println("Alterat per codi"+linea);
            }
            br.close();
            // Esto no es obligatorio pero me gusta, esperamos a que cierre
            p.waitFor();
            System.out.println("valor de salida " + p.exitValue());
        } catch (IOException | InterruptedException ex) {
            System.err.println("Error al ejecutar el proceso");

        }
    }
}
