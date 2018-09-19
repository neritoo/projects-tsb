package TSB2108;

public class ListaTSB {
    private Alumno alumnos[];
    public ListaTSB(int n)
    {
        if (n<=0) n = 4;
        alumnos = new Alumno [n];
    }

    public ListaTSB()
    {
        this(4);
    }

    public void agregarAlumno(int pos, Alumno alumnoX)
    {
        if(pos >= 0 && pos < alumnos.length && alumnoX != null)
        {
            alumnos[pos] = alumnoX;
        }

    }

    public void porcentajes()
    {
        int contador = 0;
        for(int i = 0; i < alumnos.length ; i++)
        {
            if (alumnos[i].estaAprobado())
            {
                contador ++;
            }
        }
        double porcA, porcL;
        porcA = ((double)contador * 100) / alumnos.length;
        porcL = 100 - porcA;

        System.out.println("Porcentaje de Aprobado: " + porcA + " %");
        System.out.println("Porcentaje de Libres: " + porcL + " %");

    }

    public double promedioGeneral()
    {
        int acumulador = 0;
        for(int i = 0; i < alumnos.length ; i++)
        {
            acumulador += alumnos[i].promedio();
        }
        return (double) acumulador / alumnos.length;
    }

    public String toString()
    {
        StringBuilder cadena = new StringBuilder("Lista de Alumnos de TSB");
        for(int i = 0; i < alumnos.length ; i++)
        {
            cadena.append("\nAlumno " + i + ": " + alumnos[i].toString());
        }
        return cadena.toString();
    }

    public void bubbleSortNombre()
    {
        boolean ordenado = false;
        int n = alumnos.length;

        for( int i=0; i<n-1 && !ordenado; i++ )
        {
            ordenado = true;
            for( int j=0; j<n-i-1; j++ )
            {
                if( alumnos[j].getNombreYApellido().compareTo(alumnos[j+1].getNombreYApellido())> 0 )
                {
                    Alumno aux = alumnos[j];
                    alumnos[j] = alumnos[j+1];
                    alumnos[j+1] = aux;
                    ordenado = false;
                }
            }
        }
    }
}