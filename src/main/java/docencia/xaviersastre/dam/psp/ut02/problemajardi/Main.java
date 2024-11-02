/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package docencia.xaviersastre.dam.psp.ut02.problemajardi;
/**
 * @author IMCG, modificat per
 * @author XavierSastre
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RecursJardi jardi = new RecursJardi();
        //crea un objecte RecursJardí

        for (int i = 1; i <= 10; i++) {
            (new Entra_Jardi("Entra" + i, jardi)).start();
        }//entrada de 10 fils al jardí

        for (int i = 1; i <= 15; i++) {
            (new Surt_Jardi("Surt" + i, jardi)).start();
        }//sortida de 15 fils al jardí
    }
}

