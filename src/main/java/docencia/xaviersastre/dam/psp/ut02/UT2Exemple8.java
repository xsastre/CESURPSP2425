package docencia.xaviersastre.dam.psp.ut02;

import java.util.concurrent.ThreadLocalRandom;

public class UT2Exemple8 extends Thread {
    public void run() {
System.out.println("Dins del fil:" + this.getName() +
        ", prioritat: "+this.getPriority() +
        " ID: " + this.threadId());
    }
    //
    public static void main(String[] args) {
        UT2Exemple8 h = null;
        for (int i=0; i < 5; i++) {
            h = new UT2Exemple8();  //crear fil
            h.setName("FIL" + i);   //posam nom al fil
            h.setPriority(ThreadLocalRandom.current().nextInt(1, 10));   //posam prioritat
            h.start();              //iniciar fil
            System.out.println("Informació del " +
                    h.getName() + ": " + h.toString());
        }
            System.out.println("5 FILS CREATS...");
    }   // main
}       // clase
