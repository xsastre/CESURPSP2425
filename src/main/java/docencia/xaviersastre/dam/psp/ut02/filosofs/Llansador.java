package docencia.xaviersastre.dam.psp.ut02.filosofs;

public class Llansador {
    public static void main(String[] args) {
        int NUM_PROCESSOS=5;
        Filosof filosofs[]=new Filosof[NUM_PROCESSOS];
        GestorPalillos gestorPalillos;
        gestorPalillos=new GestorPalillos(NUM_PROCESSOS);
        Thread fils[]=new Thread[NUM_PROCESSOS];
        for (int i=1; i<NUM_PROCESSOS; i++){
            filosofs[i]=new Filosof(
                    gestorPalillos, i, i-1);
            fils[i]=new Thread(filosofs[i]);
            fils[i].start();
        }
        filosofs[0]=new Filosof(
                gestorPalillos, 0, 4);
        fils[0]=new Thread(filosofs[0]);
        fils[0].start();
    }   //Fi main
}       //Fi classe