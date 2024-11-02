package docencia.xaviersastre.dam.psp.ut02.cucsnosincro;

public class SimulacioCucs {
    private static final int N = 3; // Nombre de cucs

    public static void main(String[] args) {
        Poma poma = new Poma();
        Thread[] cucs = new Thread[N];

        for (int i = 0; i < N; i++) {
            cucs[i] = new Thread(new Cuc(poma, "Cuc " + (i + 1)));
        }

        for (Thread cuc : cucs) {
            cuc.start();
        }
    }
}
