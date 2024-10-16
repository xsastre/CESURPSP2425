package docencia.xaviersastre.dam.psp.ut02;

public class Exemple1 extends Thread {
    private int c;
    private int fil;
        // constructor
    public Exemple1(int fil) {
        this.fil = fil;
        System.out.println("CREANT FIL: " + fil);
    }
    public void run( ) {
        c = 0;
        while (c <= 5) {
            System.out.println("Fil : " + fil + " C= " + c);
            c++;
        }
    }
    public static void main (String[] args) {
        Exemple1 h = null;
            for (int i=0; i<3;i++) {
                h=new Exemple1(i +1);
                h.start();
            }
            System.out.println ("3 FILS CREATS. . . " );
        } // main
    } // clase