package clases.desafio;

import java.io.*;
import java.util.Scanner;

public class Vector {
    private int vector[];

   public Vector() throws IOException {
        int contLineas = 0;
        File f = new File("lote01.txt");
        //File f = new File("pruebalote00.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        try {
            while(linea != null){
                contLineas++;
                linea = br.readLine();

            }
            vector = new int [contLineas];
        }
        catch (FileNotFoundException exc){
            System.out.println("Amigo no existe ese archivo...");
        }

    }
    //Por las dudas...
    public void setComponente(int pos, int num){
        if (pos > 0 && pos < vector.length){
            vector[pos] = num;
        }
    }

    public long getComponente(int i){
       return vector[i];

       }

    public void fillVector() throws IOException {
        File f = new File("lote01.txt");
        //File f = new File("pruebalote00.txt");

        System.out.println("Leyendo datos");

        try (Scanner myScanner = new Scanner(f)){
            while (myScanner.hasNextLong()){
                for (int i=0 ; i<vector.length ; i++){
                    vector[i] = myScanner.nextInt();
                }

            }
            System.out.println("Carga de datos completada...");
        }
        catch (FileNotFoundException exc){
            System.out.println("Amigo no existe ese archivo...");
        }

    }
    public int vectorLen(){
        return vector.length;
    }

    public String toString(){
       String cadena = "";
       for (int i=0 ; i < vector.length ; i++){
           cadena += "\n"+vector[i];
       }
       return cadena;
    }

    //Método de ordenamiento
    //Fix this
    public void mergeSort()
    {
        int n = vector.length;
        int temp[] = new int[n];
        sort(0, n-1, temp);
        System.out.println("Vector ordenado");
    }

    private void sort(int izq, int der, int temp[])
    {
        if(izq < der)
        {
            int centro = (izq + der) / 2;
            sort(izq, centro, temp);
            sort(centro + 1, der, temp);
            merge(izq, centro, der, temp);
        }
    }

    private void merge(int izq, int centro, int der, int temp[])
    {
        for(int i = izq; i <= der; i++) { temp[Math.toIntExact(i)] = vector[i]; }

        int i = izq, j = centro + 1, k = izq;
        while(i <= centro && j <= der)
        {
            if(temp[i] <= temp[j])
            {
                vector[k] = temp[i];
                i++;
            }
            else
            {
                vector[k] = temp[j];
                j++;
            }
            k++;
        }

        while(i <= centro)
        {
            vector[k] = temp[i];
            k++;
            i++;
        }
    }


    //Método de búsqueda

    public boolean binarySearch(int x)
    {
        int n = vector.length;
        int izq = 0, der = n-1;
        while(izq <= der)
        {
            int c = (izq + der)/2;
            if(x == vector[c]) return true;

            if(x < vector[c]) der = c - 1;
            else izq = c + 1;
        }
        return false;
    }

    //Métodos de negocio

    // buscar el primer número primo en el arreglo
    // calcular la mediana del arreglo
    // calcular el promedio del arreglo
    // buscar un grupo de ocho números en el arreglo
    // buscar el mayor de los números contenidos en el arreglo

    public int getPrimerPrimo() {
        int res;
        int primo=0;
        for (int i=0 ; i < vector.length ; i++){
            res = 0;
            for (int j= 1; j <= vector[i] ; j++){
                if(vector[i] % j == 0){
                    res++;

                }

            }
            if (res == 2){
                primo = vector[i];
                break;

            }

        }
        return primo;
    }

    public double getMediana(){
       double mediana;
       int i = vectorLen()/2;

       mediana = (double)(vector[i-1]+vector[i])/2;

       return mediana;
    }

    public double getPromedio(){
       long acum=0;
       long n = vectorLen();
       double prom;

       for (int i=0; i < vectorLen() ; i++){
           acum += vector[i];
       }

       prom = (double)acum / n;
       return prom;
    }

    public int getMayor(){
       int mayor=0;

       for (int i=0; i < vector.length ;i++){
            mayor = vector[i];
            for(int j=0;j<vectorLen();j++){
                if(vector[j] > mayor)
                    mayor = vector[j];
                    break;
            }
       }

       return mayor;
    }
}