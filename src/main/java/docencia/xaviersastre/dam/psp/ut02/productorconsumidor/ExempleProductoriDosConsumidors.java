package docencia.xaviersastre.dam.psp.ut02.productorconsumidor;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class COLORS {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}
class RecursCompartit {
    private Queue<Integer> coa = new LinkedList<>();
    private Stack<Thread> pilaFils = new Stack();
    private Object bloqueig = new Object();
    private int productesproduits=0;

    public void afegirFilsAlControl(Thread nouThread){
        this.pilaFils.add(nouThread);
    }
    public void obtenirEstatFils(){
        System.out.println(COLORS.ANSI_YELLOW+"Comprovant estats"+COLORS.ANSI_RESET);
        Thread filactual;
        for(int i=0;i<pilaFils.size();i++) {
            filactual=pilaFils.get(i);
            if(filactual.getState().toString().equals("WAITING") || filactual.getState().toString().equals("BLOCKED"))
                System.out.println(COLORS.ANSI_RED+filactual.getName()+" estat: "+filactual.getState()+COLORS.ANSI_RESET);
        }
    }

    public synchronized void produeix(String msg) throws InterruptedException {
        synchronized (bloqueig){  // Crei aquest bloqueig per evitar que llevin mentres vaig a posar a la pila
            productesproduits++;
            coa.add(productesproduits);
            System.out.println("Produit producte no: "+productesproduits);
        }
        notify();
    }

    public synchronized void consumeix(String nomConsumidor) throws InterruptedException {
        do {
            //isMessageAvailable=true;
            System.out.println(nomConsumidor+" espera.");
            wait();
        } while (coa.size()==0);

        System.out.println(nomConsumidor + " deixa espera va a consumir");
        String producteConsumit= coa.poll().toString();
        System.out.println(nomConsumidor + " consumeix: " + producteConsumit);

        //isMessageAvailable = false;
    }
}

public class ExempleProductoriDosConsumidors {
    public static void main(String[] args) throws InterruptedException {
        RecursCompartit sharedResource = new RecursCompartit();

        Thread controlFils = new Thread(()-> {

            try {
                while(true) {
                    Thread.sleep(500);
                    sharedResource.obtenirEstatFils();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        Thread producerThread = new Thread(() -> {
            try {
                int count = 1;
                while (true) {
                    sharedResource.produeix("Message " + count++);
                    Thread.sleep(4500); // Simula tiempo entre producciones
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"productor");
        Thread.sleep(1000); // Espera per a que es produeixin productes abans d'intentar consumir
        producerThread.start();
        sharedResource.afegirFilsAlControl(producerThread);
        controlFils.start();

        Thread consumerThread1 = new Thread(() -> {
            try {
                while (true) {
                    sharedResource.consumeix("Consumer 1");
                    Thread.sleep(2500); // Simula tiempo entre consumos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumidor1");
        consumerThread1.start();
        sharedResource.afegirFilsAlControl(consumerThread1);

        Thread consumerThread2 = new Thread(() -> {
            try {
                while (true) {
                    sharedResource.consumeix("Consumer 2");
                    Thread.sleep(3000); // Simula tiempo entre consumos
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"consumidor2");
        consumerThread2.start();
        sharedResource.afegirFilsAlControl(consumerThread2);
    }
}
