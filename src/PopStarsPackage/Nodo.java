package PopStarsPackage;

public class Nodo {
    private Cancion dato;
    private Nodo siguiente;

    public Nodo(Cancion dato, Nodo siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Cancion getDato(){
        return dato;
    }

    public Nodo getSiguiente(){
        return siguiente;
    }

    public void setDato(Cancion dato){
        this.dato = dato;
    }

    public  void setSiguiente(Nodo siguiente){
        this.siguiente = siguiente;
    }
}