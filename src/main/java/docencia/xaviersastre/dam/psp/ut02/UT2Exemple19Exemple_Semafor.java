package docencia.xaviersastre.dam.psp.ut02;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

class RecursCompartit {
    private Semaphore semafor = new Semaphore(1);

    public void accessResource(String threadName) {
        try {
            // Acquire the semaphore
            semafor.acquire();
            System.out.println(threadName + " is accessing the resource.");
            // Simulate some work with the resource
            Thread.sleep(1000);
            System.out.println(threadName + " is done with the resource.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Release the semaphore
            semafor.release();
        }
    }
}

class Fil extends Thread {
    private RecursCompartit recurs;
    private String nomFil;

    public Fil(RecursCompartit recurs, String nomFil) {
        this.recurs = recurs;
        this.nomFil = nomFil;
    }

    @Override
    public void run() {
        try {
            sleep(ThreadLocalRandom.current().nextInt(0, 2000)); // esperam un temps aleatori per evitar que sempre acabi el primer fil en primer lloc.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        recurs.accessResource(nomFil);
    }
}

public class UT2Exemple19Exemple_Semafor {
    public static void main(String[] args) {
        RecursCompartit resource = new RecursCompartit();

        // Create multiple threads
        Thread t1 = new Fil(resource, "Thread 1");
        Thread t2 = new Fil(resource, "Thread 2");
        Thread t3 = new Fil(resource, "Thread 3");

        // Start the threads
        t1.start();
        t2.start();
        t3.start();
    }
}
