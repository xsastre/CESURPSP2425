package docencia.xaviersastre.dam.psp.ut01;

import java.io.BufferedReader;
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintStream;
public class UT1Exercici02 {
    public static void main(String[] args) {
        String line;
        try {
            Process hijo = new ProcessBuilder("U1/nopublicatsencara/UT1Exercici02_c").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
            PrintStream ps = new PrintStream(hijo.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while ((in.readLine()).compareTo("fin") != 0) {
                ps.println(""); //No es necesario escribir nada ps.flush(); // Asegura que los datos se han enviado
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
