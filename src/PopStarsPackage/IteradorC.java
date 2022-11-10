package PopStarsPackage;

public class IteradorC {
    private NodoC actual;

    public IteradorC(NodoC comienzo){
        actual = comienzo;
    }

    public boolean hasNext(){
        return actual != null;
    }

    public Cantante next(){
        Cantante aux = actual.getDato();
        actual = actual.getSiguiente();
        return aux;
    }
}