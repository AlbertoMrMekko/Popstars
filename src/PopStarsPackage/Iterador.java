package PopStarsPackage;

public class Iterador {
    private Nodo actual;

    public Iterador(Nodo comienzo){
        actual = comienzo;
    }

    public boolean hasNext(){
        return actual != null;
    }

    public Cancion next(){
        Cancion aux = actual.getDato();
        actual = actual.getSiguiente();
        return aux;
    }
}