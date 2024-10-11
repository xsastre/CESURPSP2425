package docencia.xaviersastre.dam.psp.ut02;

public class Fils02 extends Thread {
    private int c;
    private int hilo;
        // constructor
    public Fils02 (int hilo) {
        this.hilo = hilo;
        System.out.println("CREANDO HILO: " + hilo);
    }
    public void run( ) {
        c = 0;
        while (c <= 5) {
            System.out.println("Hilo : " + hilo + " C= " + c);
            c++;
        }
    }
    public static void main (String[] args) {
        Fils02 h = null;
            for (int i=0; i<3;i++) {
                h=new Fils02 (i +1);
                h.start();
            }
            System.out.println ("3 HILOS CREADOS. . . " );
        } // main
    } // clase