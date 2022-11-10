package PopStarsPackage;

public class ListaOrdinal {
    private Nodo inicio, fin;
    private int numElementos;

    public ListaOrdinal(){
        inicio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean vacia(){
        return inicio == null;
    }

    public void insertarCancion(Cancion c){
        Nodo nuevo = new Nodo(c, null);
        if(this.vacia())
            inicio = nuevo;
        else
            fin.setSiguiente(nuevo);
        fin = nuevo;
        numElementos++;
    }

    public void borrarCancion(Cancion c){
        if(this.contieneCancion(c)){
            Nodo actual = inicio;
            Nodo anterior = null;
            boolean borrado = false;
            while(!borrado && actual != null) {
                if (actual.getDato().getNombre().equals(c.getNombre())) {
                    if (actual == inicio)
                        inicio = actual.getSiguiente();
                    else
                        anterior.setSiguiente(actual.getSiguiente());
                    if (actual == fin)
                        fin = anterior;
                    numElementos--;
                    borrado = true;
                } else {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        }
        else
            System.out.println("La canción no está en la lista.");

    }

    public Cancion getElemento(int posicion){
        int i = 0;
        Nodo actual = inicio;
        while(i != posicion && actual != null){
            actual = actual.getSiguiente();
            i++;
        }
        if(actual != null)
            return actual.getDato();
        else
            return null;
    }

    public int posicionCancion(Cancion c){
        Nodo actual = inicio;
        int i = 0;
        while (actual != null && !(actual.getDato().getNombre().equals(c.getNombre()))) {
            actual = actual.getSiguiente();
            i++;
        }
        if(actual != null)
            return i;
        else
            return -1;
    }

    public boolean contieneCancion(Cancion c){
        return this.posicionCancion(c) != -1;
    }

    public int getNumElementos(){
        return numElementos;
    }

    public Iterador getIterador(){
        return new Iterador(inicio);
    }
}