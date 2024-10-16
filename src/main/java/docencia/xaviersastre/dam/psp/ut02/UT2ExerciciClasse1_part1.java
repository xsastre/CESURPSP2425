package docencia.xaviersastre.dam.psp.ut02;

import java.util.*;
/**
 * Serie de Fibonacci en Java
 * Programa que imprimeix els N primers nombre de la serie de Fibonacci
 * 1, 1, 2, 3, 5, 8, 13,  ....... , N
 */
public class UT2ExerciciClasse1_part1 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int numero,fibo1,fibo2,i;

        do{
            System.out.print("Introdueix un nombre major que 1: ");
            numero = sc.nextInt();
        }while(numero<=1);

        System.out.println("Els " + numero + " primers termes o elements de la serie de Fibonacci son:");

        fibo1=1;
        fibo2=1;

        System.out.print(fibo1 + " ");
        for(i=2;i<=numero;i++){
            System.out.print(fibo2 + " ");
            fibo2 = fibo1 + fibo2;
            fibo1 = fibo2 - fibo1;
        }
        System.out.println();
    }
}