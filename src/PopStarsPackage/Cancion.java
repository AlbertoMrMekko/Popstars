package PopStarsPackage;

public class Cancion {
    private String nombre;
    private double nota;

    public Cancion(String nombre){
        this.nombre = nombre;
        nota = 5.0;
    }

    public Cancion(String nombre, double nota){
        this.nombre = nombre;
        if(nota >= 0 && nota <=10)
            this.nota = nota;
        else
            this.nota = 5.0;
    }

    public String getNombre(){
        return nombre;
    }

    public double getNota(){
        return nota;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
}