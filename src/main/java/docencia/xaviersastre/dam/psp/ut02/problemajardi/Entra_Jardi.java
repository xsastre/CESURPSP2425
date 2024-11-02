/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package docencia.xaviersastre.dam.psp.ut02.problemajardi;

/**
 * @author IMCG, modificat per
 * @author XavierSastre
 */
public class Entra_Jardi extends Thread {
//classe derivada de Thread que defineix un fil
    private RecursJardi jardi;

    public Entra_Jardi(String nom, RecursJardi j) {
        this.setName(nom);
        this.jardi = j;
    }

    @Override
    public void run() {
        jardi.incrementaCompte();
        //invoca el mètode que incrementa el compta d'accessos al jardí
    }
}



