package docencia.xaviersastre.dam.psp.ut01;

import java.io.File;
import java.io.IOException;

public class Processos05 {

    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir");
            // usamos path separator para mejorar la detección del path del sistema
            String pathDir = path+ File.separator+"prova_codi_exemple05.txt";
            System.out.println(pathDir);
            //Process p1 = Runtime.getRuntime().exec ("code" + pathDir);
            Process p1 = Runtime.getRuntime().exec ("code"+pathDir);
            // Ahora dejamos el programa bloqueado (este de java) hasta que se cierre el otro
            p1.waitFor();
            System.out.println("valor de salida " + p1.exitValue());
        }catch (IOException ex) {
            System.err.println("Error al lanzar proceso");
        } catch (InterruptedException ex) {
            System.err.println("Error n waitFor");
        }
    }
}
