package clases;

import clases.desafio.Vector;

import java.io.*;


public class Pruebas {
    public static void main(String[]args) throws IOException{

        //Arreglar el metodo de ordenamiento

        Vector v1 = new Vector();
        v1.fillVector();
       //Si haces esto rip cpu
        //System.out.println(v1);
        v1.mergeSort();

        for(int i=0;i < 2;i++)
            System.out.println(v1.getComponente(i));
       // System.out.println("primo");
        //System.out.println(v1.getPrimerPrimo());

        /*int vec[] = new int[4];
        vec[0] = 7;
        vec[1] = 8;
        vec[2] = 10;
        vec[3] = 2;

        int res;
        for (int i=0 ; i < vec.length ; i++){
            res = 0;
            for (int j= 1; j <= vec[i] ; j++){
                if(vec[i] % j == 0){
                    res++;

                }

            }

        if (res == 2){
            System.out.println(vec[i]);
            break;
        }

        }*/


    }


}
