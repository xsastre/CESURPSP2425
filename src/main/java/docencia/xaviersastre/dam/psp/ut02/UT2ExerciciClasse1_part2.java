package docencia.xaviersastre.dam.psp.ut02;

class Fibonacci extends Thread {

    int nombreelements;
    Fibonacci(int nombre) {
        this.nombreelements = nombre;
    }
    public void run() {
        System.out.println("Hola des del fil creat!");
        int numero,fibo1,fibo2,i;

        System.out.println("Els " + this.nombreelements + " primers termes o elements de la serie de Fibonacci son:");

        fibo1=1;
        fibo2=1;

        System.out.print(fibo1 + " ");
        for(i=2;i<=this.nombreelements;i++){
            System.out.print(fibo2 + " ");
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
        System.out.println();
    }
}
public class UT2ExerciciClasse1_part2 {
    public static void main(String args[]) {

        Thread fibo=new Fibonacci(15);
        fibo.start();// Crea y arrenca un nou fil d’execució
        System.out.println("Hola des del fil principal!");
        System.out.println("Procés pare acabant.");
    }
}
