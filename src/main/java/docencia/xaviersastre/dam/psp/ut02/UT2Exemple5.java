package docencia.xaviersastre.dam.psp.ut02;


public class UT2Exemple5 {
    public static void main(String[] args) {
        int NUM_HILOS=100;
        Thread[] hilosAsociados;

        hilosAsociados=new Thread[NUM_HILOS];
        for (int i=0;i<NUM_HILOS;i++){
            TareaCompleja t=new TareaCompleja();
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