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
    public void setComponente(int pos, int num){
        if (pos > 0 && pos < vector.length){
            vector[pos] = num;
        }
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
}
