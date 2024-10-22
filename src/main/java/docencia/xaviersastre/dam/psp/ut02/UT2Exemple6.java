package docencia.xaviersastre.dam.psp.ut02;

import java.util.Random;

class TascaComplexa2 implements Runnable{
    @Override
    public void run() {
        Random generador= new Random();
        int numAtzar=(1+generador.nextInt(5))*100;
        for (int i=0; i<numAtzar;i++){
            int a=i*3;
        }
        Thread filActual=Thread.currentThread();
        String elmeuNom=filActual.getName();
        System.out.println(
                "Finalitzat el fil"+elmeuNom
                );
    }
}
public class UT2Exemple6 {
    public static void main(String[] args) {
        int NUM_FILS=100;
        Thread[] filsAssociats;

        filsAssociats=new Thread[NUM_FILS];
        for (int i=0;i<NUM_FILS;i++){
            TascaComplexa2 t=new TascaComplexa2();
            Thread fil=new Thread(t);
            fil.setName("fil: "+i);
            fil.start();
            filsAssociats[i]=fil;
        }

        /* Després de crear-ho tot, ens asseguram
         * d'esperar que tots els fils acabin. */

        for (int i=0; i<NUM_FILS; i++){
            Thread fil=filsAssociats[i];
            try {
                //Espera a que el fil acabe
                fil.join();
            } catch (InterruptedException e) {
                System.out.print("Algun fil ha acabat ");
                System.out.println(" abans de temps!");
            }
        }
        System.out.println("El principal ha acabat");
    }
}