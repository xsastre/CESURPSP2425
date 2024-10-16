package docencia.xaviersastre.dam.psp.ut02.filosofs;

import java.util.Random;
public class Filosof implements Runnable{
    GestorPalillos gestorPalillos;
    int posPalilloEsq, posPalilloDre;
    public Filosof(GestorPalillos g, int pEsq, int pDre){
        this.gestorPalillos=g;
        this.posPalilloDre =pDre;
        this.posPalilloEsq =pEsq;
    }
    public void run() {
        while (true){
            boolean palillosAgafats;
            palillosAgafats=
                    this.gestorPalillos.intentarAgafarPalillos(
                            posPalilloEsq, posPalilloDre);
            if (palillosAgafats){
                menjar();
                this.gestorPalillos.alliberarPalillos(
                        posPalilloEsq,
                        posPalilloDre);
                dormir();
            }   //Fi if
        }       //Fi while true
    }           //Fi run()

    private void menjar() {
        System.out.println("Filosof "+
                Thread.currentThread().getName()+
                " menjant");
        esperarTempAtzar();
    }
    private void esperarTempAtzar() {
        Random generador=new Random();
        int msAtzar=generador.nextInt(5000);
        try {
            Thread.sleep(msAtzar);
        } catch (InterruptedException ex) {
            System.out.println("Error en l'espera");
        }
    }
    private void dormir(){
        System.out.println("Filosof "+
                Thread.currentThread().getName()+
                " dormint (zzzzzz)");
        esperarTempAtzar();
    }
}