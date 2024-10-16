package docencia.xaviersastre.dam.psp.ut02;
class HelloThread  extends Thread {
    public void run() {
        System.out.println("Hola des del fil creat!");
    }
}
public class UT2Exemple2 {
    public static void main(String args[]) {

        new HelloThread().start();// Crea y arrenca un nou fil d’execució
        System.out.println("Hola des del fil principal!");
        System.out.println("Procés acabant.");
    }
}
