package clases.negocio;

public class Persona implements Comparable, java.io.Serializable {
    private String apellido;
    private String nombre;

    public Persona(String apellido, String nombre) {
        this.apellido = apellido;
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int compareTo(Object x){
        int r;
        Persona p = (Persona) x;
        int ca = apellido.compareTo(p.apellido);
        int cn = nombre.compareTo(p.nombre);
        if(ca == 0 && cn == 0)
            r = 0;
        else
            r = ca;

        return r;
    }

    public String toString(){
        return "Persona: " + apellido + ", " + nombre;
    }

}