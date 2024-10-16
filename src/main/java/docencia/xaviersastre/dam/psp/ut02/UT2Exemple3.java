package docencia.xaviersastre.dam.psp.ut02;

class ExecutorTascaComplexa implements Runnable{
    private String nombre;
    int numExecucio;
    public ExecutorTascaComplexa(String nombre){
        this.nombre=nombre;
    }
    @Override
    public void run() {
        String cad;
        while (numExecucio <100){
            for (double i=0; i<4999.99; i=i+0.04)
            {
                Math.sqrt(i);
            }
            cad="Som el fil "+this.nombre;
            cad+=" i el meu valor de i és "+ numExecucio;
            System.out.println(cad);
            numExecucio++;
        }
    }

}
public class UT2Exemple3 { // Llançafils
    /**
     * @param args
     */
    public static void main(String[] args) {
        int NUM_FILS=500;
        ExecutorTascaComplexa op;
        for (int i=0; i<NUM_FILS; i++)
        {
            op=new ExecutorTascaComplexa("Operacio "+i);
            Thread hilo=new Thread(op);
            hilo.start();
        }
    }
}