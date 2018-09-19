package TSB2108;

public class Alumno {
    private int legajo, notas[];
    private String nombreApellido;

    public Alumno (int leg, String nom)
    {
        legajo = leg;
        nombreApellido = nom;
        notas = new int[3];

    }

    public void setNota(int pos, int nota)
    {
        if(pos >= 0 && pos < 3 && nota >= 0 && nota <= 10)
        {
            notas[pos] = nota;
        }
    }

    public String toString()
    {
        String cadena = "";
        cadena += "Legajo: " + legajo;
        cadena += "\nNombre y Apellido: " + nombreApellido;

        for(int i = 0; i < notas.length ; i++)
        {
            cadena += "\nNota  " + (i+1) + ": " + notas[i];
        }
        return cadena;
    }

    public boolean estaAprobado()
    {
        boolean aprobado = true;
        for(int i = 0; i < notas.length ; i++)
        {
            if (notas[i] < 6)
            {
                aprobado = false;
                break;
            }
        }
        return aprobado;
    }

    public int getLegajo()
    {
        return legajo;
    }

    public String getNombreYApellido()
    {
        return nombreApellido;
    }

    public int promedio()
    {
        int i, acumulador = 0;
        for(i = 0 ; i < notas.length ; i++)
        {
            acumulador += notas[i];
        }
        return acumulador / i;
    }

}
