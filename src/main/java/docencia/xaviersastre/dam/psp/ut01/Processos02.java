package docencia.xaviersastre.dam.psp.ut01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Processos02 {

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        // -- Linux --
        // Run a shell command
        processBuilder.command("bash", "-c", "ls ./");
        // Run a shell script
        //processBuilder.command("path/to/hello.sh");

        // -- Windows --

        // Run a command
        //processBuilder.command("cmd.exe", "/c", "dir C:\\");

        // Run a bat file
        //processBuilder.command("C:\\Users\\link\\hello.bat");

        try {

            Process process = processBuilder.start();
            StringBuilder output = new StringBuilder();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }

            int exitVal = process.waitFor();
            if (exitVal == 0) {
                System.out.println("Success!");
                System.out.println(output);
                System.exit(0);
            } else {
                //abnormal...
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
