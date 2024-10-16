package docencia.xaviersastre.dam.psp.ut01;

import java.io.IOException;
import java.util.Arrays;
public class ExemplePSP00_ProcessSincronization {
    public static void main(String[] args) throws IOException, InterruptedException {
        try {
            Process process = new ProcessBuilder(args).start();
            int retorn = process.waitFor();
            System.out.println("Instrucció " + Arrays.toString(args) + "retorna: " + retorn);
        }
            catch (IOException e) {
                System.out.println("Error executant la instrucció: " + e.getMessage());
            } catch (InterruptedException e) {
            System.out.println("La instrucció ha estat interrompuda. Descripció de l'error: "+e.getMessage());
            }
        }
    }
