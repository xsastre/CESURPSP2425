package docencia.xaviersastre.dam.psp.ut01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExemplePSP01 {
    public static void main(String[] args) {
        try {
            Process proces = new ProcessBuilder("python3", "U1/ExemplePSP01.py").start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proces.getInputStream()));
            proces.waitFor();
            int exitStatus = proces.exitValue();
            System.out.println("Retorn: " + br.readLine());
            System.out.println("Valor de sortida:" + exitStatus);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
