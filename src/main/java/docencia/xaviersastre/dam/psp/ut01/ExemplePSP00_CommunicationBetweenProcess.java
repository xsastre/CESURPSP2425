package docencia.xaviersastre.dam.psp.ut01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ExemplePSP00_CommunicationBetweenProcess {
    public static void main(String args[]) throws IOException {
        Process process = new ProcessBuilder(args).start();
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;

        System.out.println("Sortida del proces "+Arrays.toString(args)+":");
        while ((line=br.readLine()) != null) {
            System.out.println(line);
        }
    }
}