package clases;
import clases.negocio.*;
import clases.soporte.*;


public class App {

    public static void main(String[]args){
        Persona p1 = new Persona("Perez", "Juan");
        Persona p2 = new Persona("Bolivar", "Simon");
        Persona p3 = new Persona("Polanco", "Jimena");
        Persona p4 = new Persona("Ramirez", "Sofia");

        Reunion r1 = new Reunion("10000");
        r1.agregarParticipante(p1);
        r1.agregarParticipante(p3);
        Reunion r2 = new Reunion("1230");
        r2.agregarParticipante(p2);
        r2.agregarParticipante(p4);
        Reunion r3 = new Reunion("1500");
        r3.agregarParticipante(p1);
        r3.agregarParticipante(p2);
        r3.agregarParticipante(p3);
        r3.agregarParticipante(p4);
        Reunion r4 = new Reunion ("1800");
        r4.agregarParticipante(p1);
        r4.agregarParticipante(p4);

        Sala s1 = new Sala(1);
        s1.agregarReunion(r1);
        s1.agregarReunion(r2);
        s1.agregarReunion(r3);
        s1.agregarReunion(r4);

        System.out.println(s1);
        System.out.println("Cantidad de reuniones: " + s1.cantidadReuniones());
        System.out.println("Cantidad total de participantes: " + s1.cantidadParticipantes());
        System.out.println("Ultima reunion: " + s1.getUltimaReunion());
        System.out.println("Cantidad de reuniones de 'Juan Perez': " + s1.cantidadAsistencias(p1));
        System.out.println("Cantidad de reuniones de 'Juan Perez'(PatronIterador): " + s1.cantidadAsistenciasIterador(p1));

        boolean r = s1.grabar();
        if (!r){
            System.out.println("No se pudo grabar");
        }
        Sala x = s1.leer();

        System.out.println("Objeto serializado: " + x);



    }



}
