package docencia.xaviersastre.dam.psp.ut02.supermercat;


import java.util.ArrayList;

public class SPU02E03_caixa_i_coa_uniques {

    public static final int N=1;
    public static final int M=5;
    public static final int TEMPS_ESPERA_MAXIM=5000;
    static ArrayList<String> noms = new ArrayList<String>();
    static ArrayList<String> coa = new ArrayList<String>();
    //static Queue coa=new LinkedList();
    public static int caixes_disponibles=1;
    public static int caixa_total=0;

    static class Client extends Thread {
        private static final double TEMPS_ESPERA_MAXIM = 15000;
        String nom ="";
        Caixa caixa;
        coa_Unica coa_unica;
        boolean ates=false;
        Client(String nom, coa_Unica coa_unica){
            this.nom=nom;
            this.coa_unica=coa_unica;
            this.caixa=new Caixa("1",coa_unica);
        }
        public void Espera() {
            try {
                sleep((int)(Math.random()*TEMPS_ESPERA_MAXIM));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        @Override
        public void run() {
            System.out.println("Client "+nom+" ha entrat al supermercat");
            Espera();
            System.out.println("Client "+nom+" va a la caixa");
            System.out.println("Client "+nom+" esta a la posicio "+coa_unica.Encoar(nom));

            coa_unica.Esperar_torn(nom);
            System.out.println("Client "+nom+" va a pagar");
            System.out.println("Client "+nom+" ha pagat: "+caixa.Cobrar());

        }
    }


    static class coa_Unica {

        synchronized public int Encoar(String nom_client) {
            coa.add(nom_client);
            //Esperar_torn(nom_client);
            //return coa.indexOf(nom_client);
            return coa.size();
        }
        synchronized void Desencoar(String nom_client) {
            coa.remove(nom_client);
        }
        synchronized void pitja_boto_disponible() {
            notifyAll();
            caixes_disponibles++;
        }

        void mostra_coa() {
            System.out.print("Coa: ");
            for (String s : coa) {
                System.out.print(s.toString()+" ");
            }
            System.out.println();
        }

        public synchronized void Esperar_torn(String nom) {
            //while ((!(nom.equals(coa.get(0)))) || (caixes_disponibles==0)) {
            System.out.println("Primer lloc de la coa per: "+coa.get(0));
            while (!(nom.equals(coa.get(0)))) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            while (!(caixes_disponibles>0)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            caixes_disponibles--;
            mostra_coa();
            System.out.println(nom+" acaba de despertar-se");
            System.out.println("Numero de caixes disponibles: "+caixes_disponibles);
            coa.remove(nom);
        }

    }

    static class Caixa {

        String nom = "";
        coa_Unica coa_unica;

        Caixa(String name, coa_Unica coa) {
            this.nom = name;
            this.coa_unica=coa;
        }
        int Cobrar() {
            int doblers=0;
            doblers=(int)(Math.random()*500+1);
            caixa_total+=doblers;
            try {
                Thread.sleep((int)(Math.random()*TEMPS_ESPERA_MAXIM));
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            coa_unica.pitja_boto_disponible();
            return doblers;
        }


    }

    static void omple_noms() {
        noms.add("Tofol");
        noms.add("Miquel");
        noms.add("Biel");
        noms.add("Hugo");
        noms.add("Lluc");
        noms.add("Mateo");
        noms.add("Mitchell");
        noms.add("Dani");
        noms.add("Paco");
        noms.add("Rolando");
        noms.add("Salva");
        noms.add("Illan");
    }


    public static void main(String[] args) {

        Caixa[] caixa=new Caixa[N];
        Client[] client=new Client[M];
        coa_Unica coa_unica=new coa_Unica();
        omple_noms();

        for (int i=0;i<N;i++) {
            caixa[i]=new Caixa(String.valueOf(i+1),coa_unica);
        }
        for (int i=0;i<M;i++) {
            client[i]=new Client(noms.remove((int)(Math.random()*noms.size())),coa_unica);
            client[i].start();
        }


        for (int i=0;i<M;i++) {
            try {
                client[i].join();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Total caixa: "+caixa_total);
    }
}
