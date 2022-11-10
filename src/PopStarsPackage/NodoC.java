package PopStarsPackage;

public class NodoC {
    private Cantante dato;
    private NodoC siguiente;

    public NodoC(Cantante dato, NodoC siguiente){
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public Cantante getDato(){
        return dato;
    }

    public NodoC getSiguiente(){
        return siguiente;
    }

    public void setDato(Cantante dato){
        this.dato = dato;
    }

    public void setSiguiente(NodoC siguiente){
        this.siguiente = siguiente;
    }

    public String getClave(){
        return this.dato.getNombre();
    }
}
