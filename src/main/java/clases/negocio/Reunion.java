package clases.negocio;

import clases.soporte.TSBSimpleList;

public class Reunion implements Comparable, java.io.Serializable {

    private String hora;
    private TSBSimpleList participantes;

    public Reunion(String hora){
        this.hora = hora;
        participantes = new TSBSimpleList();

    }

    public void setHora(){
        this.hora = hora;
    }

    public String getHora(){
        return hora;
    }

    public void agregarParticipante(Persona x){
        participantes.addFirst(x);

    }

    public int compareTo(Object x){
        Reunion r = (Reunion) x;
        return hora.compareTo(r.hora);
    }

    public String toString(){
        String cadena = "\nHora: " + hora;
        cadena += "\nParticipantes: \n" + participantes.toString();

        return cadena;
    }

    public int cantidadParticipantes(){

        return participantes.size();
    }

    public boolean estaParticipante( Persona x){
        return participantes.contains(x);
    }
}
