package clases.desafio;

import java.io.*;
import java.util.Scanner;

public class Vector {
    private long vector[];

   public Vector() throws IOException {
        int contLineas = 0;
        File f = new File("lote01.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea = br.readLine();

        try {
            while(linea != null){
                contLineas++;
                linea = br.readLine();

            }
            vector = new long [contLineas];
        }
        catch (FileNotFoundException exc){
            System.out.println("Amigo no existe ese archivo...");
        }

    }
    //Por las dudas...
    public void setComponente(int pos, long num){
        if (pos > 0 && pos < vector.length){
            vector[pos] = num;
        }
    }

    public long getComponente(int i){
       return vector[i];

       }

    public void fillVector() throws IOException {
        File f = new File("lote01.txt");

        System.out.println("Leyendo datos");

        try (Scanner myScanner = new Scanner(f)){
            while (myScanner.hasNextLong()){
                for (int i=0 ; i<vector.length ; i++){
                    vector[i] = myScanner.nextLong();
                }

            }
            System.out.println("Carga de datos completada...");
        }
        catch (FileNotFoundException exc){
            System.out.println("Amigo no existe ese archivo...");
        }

    }
    //Ignora, era para probar que cuenta bien las lineas...
    public int cantLin(){
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
        long n = vector.length;
        long temp[] = new long[Math.toIntExact(n)];
        sort(0, n-1, temp);
        System.out.println("Vector ordenado");
    }

    private void sort(long izq, long der, long temp[])
    {
        if(izq < der)
        {
            long centro = (izq + der) / 2;
            sort(izq, centro, temp);
            sort(centro + 1, der, temp);
            merge(izq, centro, der, temp);
        }
    }

    private void merge(long izq, long centro, long der, long temp[])
    {
        for(long i = izq; i <= der; i++) { temp[Math.toIntExact(i)] = vector[Math.toIntExact(i)]; }

        long i = izq, j = centro + 1, k = izq;
        while(i <= centro && j <= der)
        {
            if(temp[Math.toIntExact(i)] <= temp[Math.toIntExact(j)])
            {
                vector[Math.toIntExact(k)] = temp[Math.toIntExact(i)];
                i++;
            }
            else
            {
                vector[Math.toIntExact(k)] = temp[Math.toIntExact(j)];
                j++;
            }
            k++;
        }

        while(i <= centro)
        {
            vector[Math.toIntExact(k)] = temp[Math.toIntExact(i)];
            k++;
            i++;
        }
    }


    //Método de búsqueda

    public int binarySearch(int x)
    {
        int n = vector.length;
        int izq = 0, der = n-1;
        while(izq <= der)
        {
            int c = (izq + der)/2;
            if(x == vector[c]) return c;

            if(x < vector[c]) der = c - 1;
            else izq = c + 1;
        }
        return -1;
    }

    //Métodos de negocio

    //buscar el primer número primo en el arreglo
    // calcular la mediana del arreglo
    // calcular el promedio del arreglo
    // buscar un grupo de ocho números en el arreglo
    // buscar el mayor de los números contenidos en el arreglo

    public long getPrimerPrimo() {
        int res;
        long primo=0;
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
}