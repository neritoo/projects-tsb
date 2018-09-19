package TSB2108;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ListaTSB l1 = new ListaTSB();

        Alumno a1 = new Alumno(67858, "Gavilan, Ezequiel");
        a1.setNota(0, 9);
        a1.setNota(1, 7);
        a1.setNota(2, 8);
        l1.agregarAlumno(0, a1);

        Alumno a2 = new Alumno(70548, "Analiz, Jorge");
        a2.setNota(0, 6);
        a2.setNota(1, 2);
        a2.setNota(2, 0);
        l1.agregarAlumno(1, a2);

        Alumno a3 = new Alumno(73525, "Polanco, Melina");
        a3.setNota(0, 7);
        a3.setNota(1, 6);
        a3.setNota(2, 8);
        l1.agregarAlumno(2, a3);

        Alumno a4 = new Alumno(68954, "Bomar, Agustina");
        a4.setNota(0, 10);
        a4.setNota(1, 8);
        a4.setNota(2, 8);
        l1.agregarAlumno(3, a4);


        l1.porcentajes();
        System.out.println("Promedio General: " + l1.promedioGeneral());

        l1.bubbleSortNombre();
        System.out.println(l1);
    }
}