package docencia.xaviersastre.dam.psp.ut02.cucsnosincro;

public class Poma {
    private int percentatge = 100;

    public void menjar(int quantitat, String cuc) {
        if (percentatge >= quantitat) {
            percentatge -= quantitat;
            System.out.println(cuc + " està menjant ("+quantitat+"). Percentatge de poma restant quan acabi de menjar: " + percentatge + "%");
        } else {
            quantitat=percentatge;
            percentatge -= quantitat;
            System.out.println(cuc + " s'acabarà la poma");
        }
    }

    public int getPercentatge() {
        return percentatge;
    }
}
