package docencia.xaviersastre.dam.psp.ut01;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Processos14 {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("¿Cuántas veces deseas abrir TextEdit? ");
            int numVeces = scanner.nextInt();

            List<Process> processes = new ArrayList<>();

            // Abrir todas las instancias al mismo tiempo
            for (int i = 0; i < numVeces; i++) {
                try {
                    ProcessBuilder processBuilder = new ProcessBuilder("open", "-a", "safari");
                    Process process = processBuilder.start();
                    processes.add(process);
                } catch (IOException e) {
                    System.err.println("Error al iniciar TextEdit: " + e.getMessage());
                }
            }

            // Cerrar las instancias una a una con un intervalo de 5 segundos
            for (Process process : processes) {
                try {
                    Thread.sleep(5000);
                    process.destroy();
                    System.out.println("Proceso cerrado.");
                } catch (InterruptedException e) {
                    System.err.println("Error al cerrar el proceso: " + e.getMessage());
                }
            }
        }
    }