package clases.negocio;
import clases.soporte.TSBSimpleList;

import java.io.*;

public class Sala implements java.io.Serializable {

    private int numero;
    private TSBSimpleList reuniones;

    public Sala(int numero){
        this.numero = numero;
        reuniones = new TSBSimpleList();

    }

    public void agregarReunion(Reunion x){
        reuniones.addInOrder(x);
    }

    public String toString(){
        String cadena = "\nNumero de sala: " + numero;
        cadena += "\nReuniones: \n" + reuniones.toString();
        return cadena;
    }

    public int cantidadReuniones(){
        return reuniones.size();
    }

    public int cantidadParticipantes(){
        int acu = 0;
        reuniones.iniciarPasos();
        for (int i=0 ; i < reuniones.size() ; i++){
            Reunion r = (Reunion) reuniones.get(i);
            acu += r.cantidadParticipantes();
        }
        System.out.println("Cantidad de pasos: " + reuniones.getPasos());
        return acu;
    }

    public Reunion getUltimaReunion(){
        return (Reunion) reuniones.getLast();
    }

    public int cantidadAsistencias(Persona x){
        reuniones.iniciarPasos();
        int contador = 0;
        for (int i=0; i < reuniones.size() ;i++){
            Reunion r = (Reunion) reuniones.get(i);
            if (r.estaParticipante(x))
                contador++;
        }
        System.out.println("Cantidad de pasos: " + reuniones.getPasos());
        return contador;
    }

    //Utilizando el patron iterador -> ARREGLAR (una opcion seria usar el for anterior)

    public int cantidadAsistenciasIterador(Persona x){
        reuniones.iniciarPasos();
        int contador = 0;

        reuniones.iniciarIterador();
        while (reuniones.haySiguiente()){
            Reunion r = (Reunion) reuniones.getActual();
            if (r.estaParticipante(x))
                contador++;
            reuniones.avanzar();
        }
        System.out.println("Cantidad de pasos: " + reuniones.getPasos());
        return contador;
    }

    public boolean grabar(){
        File f = new File("sala.dat");

        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this);
            oos.close();
            fos.close();
        }
        catch (IOException e){
            return false;
        }

        return true;
    }

    public Sala leer(){
        Sala s = null;
        File f = new File("sala.dat");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            s = (Sala) ois.readObject();
            ois.close();
            fis.close();
        }

        catch (ClassNotFoundException e){

        }
        catch (FileNotFoundException e){
            System.err.println("Error de lectura: el archivo no existe");

        }

        catch (IOException e){

        }


        return s;
    }
}
