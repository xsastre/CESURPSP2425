package docencia.xaviersastre.dam.psp.ut02.cucs;

class Cuc implements Runnable {
    private Poma poma;
    private String nom;

    public Cuc(Poma poma, String nom) {
        this.poma = poma;
        this.nom = nom;
    }

    @Override
    public void run() {
        while (poma.getPercentatge() > 0) {
            int quantitat = (int) (Math.random() * 10) + 1; // Quantitat aleatòria entre 1 i 10
            poma.menjar(quantitat, nom);
            try {
                Thread.sleep((int) (Math.random() * 1000)); // Dormir un temps aleatori entre 0 i 1000 ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nom + " ha acabat de menjar.");
    }
}
