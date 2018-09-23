package clases;

import clases.desafio.Vector;
import java.util.Scanner;
import java.io.*;


public class Pruebas {
    public static void main(String[]args) throws IOException{
        Scanner sc = new Scanner(System.in);

        Vector v1 = new Vector();
        v1.fillVector();

        System.out.println("Primer primo: " + v1.getPrimerPrimo());
        System.out.println("Promedio: "+v1.getPromedio());
        v1.mergeSort();
        System.out.println("Mediana: " + v1.getMediana());
        System.out.print("n: ");
        int n = sc.nextInt();
        System.out.println(v1.binarySearch(n));
        System.out.println("Mayor valor: " + v1.getMayor());
    }


}
