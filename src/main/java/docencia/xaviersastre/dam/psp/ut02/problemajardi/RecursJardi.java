/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package docencia.xaviersastre.dam.psp.ut02.problemajardi;

/**
 * @author IMCG, modificat per
 * @author XavierSastre
 */

public class RecursJardi {
    //classe que simula les entrades i les sortides al jardí
    private int compte; //per comptar les entrades i sortides al Jardí
    public RecursJardi() {
        compte = 100; //inicialment hi ha 50 persones al jardí
    }
    public void incrementaCompte() {
        //mètode que incrementa en 1 la variable compta
        System.out.println("fil " + Thread.currentThread().getName()
                + "----- Entra en el Jardí");
        //mostra el fil que entra en el mètode
        compte++;
        System.out.println(compte + " en el jardí");
        //compta cada accés al jardí i mostra el nombre d' accessos
    }
   public void decrementaCompte() {
        //mètode que decrementa en 1 la variable compte
        System.out.println("fil " + Thread.currentThread().getName()
                + "----- Surt del jardí");
        //mostra el fil que surt en el mètode
        compte--;
        System.out.println(compte + " en el jardí");
        //compta cada accés al jardí i mostra el nombre d'accessos
    }
}
