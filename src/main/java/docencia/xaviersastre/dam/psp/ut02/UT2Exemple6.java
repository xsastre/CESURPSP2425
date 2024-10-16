package docencia.xaviersastre.dam.psp.ut02;

import java.util.Random;

class TareaCompleja2 implements Runnable{
    @Override
    public void run() {
        Random generador= new Random();
        int numAzar=(1+generador.nextInt(5))*100;
        for (int i=0; i<numAzar;i++){
            int a=i*3;
        }
        Thread hiloActual=Thread.currentThread();
        String miNombre=hiloActual.getName();
        System.out.println(
                "Finalizado el hilo"+miNombre);
    }
}
public class UT2Exemple6 {
    public static void main(String[] args) {
        int NUM_HILOS=100;
        Thread[] hilosAsociados;

        hilosAsociados=new Thread[NUM_HILOS];
        for (int i=0;i<NUM_HILOS;i++){
            TareaCompleja2 t=new TareaCompleja2();
            Thread hilo=new Thread(t);
            hilo.setName("Hilo: "+i);
            hilo.start();
            hilosAsociados[i]=hilo;
        }

        /* Despues de crear todo, nos aseguramos
         * de esperar que todos los hilos acaben. */

        for (int i=0; i<NUM_HILOS; i++){
            Thread hilo=hilosAsociados[i];
            try {
                //Espera a que el hilo acabe
                hilo.join();
            } catch (InterruptedException e) {
                System.out.print("Algun hilo acabó ");
                System.out.println(" antes de tiempo!");
            }
        }
        System.out.println("El principal ha terminado");
    }
}