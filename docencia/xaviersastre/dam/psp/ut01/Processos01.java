package docencia.xaviersastre.dam.psp.ut01;

import java.io.File;

public class Processos01 {

    public static void main(String[] args) {
        // Path Actual, directorio de la BD
        String path = System.getProperty("user.dir");
        // usamos path separator para mejorar la detección del path del sistema
        String pathDir = path+ File.separator+"src"+File.separator;
        System.out.println(pathDir);
    }
}
