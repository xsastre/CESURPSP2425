/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package docencia.xaviersastre.dam.psp.ut02.problemajardi;

/**
 * @author IMCG, modificat per
 * @author XavierSastre
 */
public class Surt_Jardi extends Thread {
//classe derivada de Thread que defineix un fil
    private RecursJardi jardi;
    public Surt_Jardi(String nom, RecursJardi j) {
        this.setName(nom);
        this.jardi = j;
    }

    @Override
    public void run() {
        jardi.decrementaCompte();
        //invoca el mètode que decrementa el compte d'accessos al jardí
    }
}
