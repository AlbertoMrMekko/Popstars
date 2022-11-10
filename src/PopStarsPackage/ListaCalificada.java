package PopStarsPackage;

public class ListaCalificada {
    private NodoC inicio;
    private int numElementos;

    public ListaCalificada(){
        inicio = null;
        numElementos = 0;
    }

    public boolean vacia(){
        return inicio == null;
    }

    public void insertarCantante(Cantante c){
        NodoC nuevo = new NodoC(c, null);
        if(vacia()){
            inicio = nuevo;
            numElementos++;
        }
        else{
            NodoC actual = inicio;
            NodoC anterior = null;
            while(actual != null && nuevo.getClave().compareTo(actual.getClave()) > 0)
            {
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if(actual == inicio && nuevo.getClave().compareTo(actual.getClave()) < 0){
                nuevo.setSiguiente(inicio);
                inicio = nuevo;
                numElementos++;
            }
            else if(actual == null){
                anterior.setSiguiente(nuevo);
                numElementos++;
            }
            else
            if(nuevo.getClave().compareTo(actual.getClave()) < 0){
                anterior.setSiguiente(nuevo);
                nuevo.setSiguiente(actual);
                numElementos++;
            }
            else
                System.out.println("Error, la cantante ya existe.");
        }
    }

    public void borrarCantante(Cantante c){
        if(vacia())
            System.out.println("La cantante no está en la lista.");
        else if(numElementos == 1)
            if(inicio.getClave().equals(c.getNombre())){
                inicio = null;
                numElementos--;
            }
            else
                System.out.println("La cantante no está en la lista.");
        else{
            NodoC actual = inicio;
            NodoC anterior = null;
            while(actual != null && c.getNombre().compareTo(actual.getClave()) > 0){
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if(actual == null)
                System.out.println("La cantante no está en la lista.");
            else if(!actual.getClave().equals(c.getNombre()))
                System.out.println("La cantante no está en la lista.");
            else{
                anterior.setSiguiente(actual.getSiguiente());
                numElementos--;
            }
        }
    }

    public Cantante getElemento(int posicion){
        if(posicion >= 0 && posicion < numElementos){
            int i = 0;
            NodoC actual = inicio;
            while(i != posicion && actual != null){
                actual = actual.getSiguiente();
                i++;
            }
            if(actual != null)
                return actual.getDato();
            else
                return null;
        }
        else
            return null;
    }

    public int posicionCantante(Cantante c){
        NodoC actual = inicio;
        int i = 0;
        while(actual != null && actual.getClave().compareTo(c.getNombre()) < 0){
            actual = actual.getSiguiente();
            i++;
        }
        if(actual != null && actual.getClave().equals(c.getNombre()))
            return i;
        else
            return -1;
    }

    public boolean contieneCantante(Cantante c){
        return this.posicionCantante(c) != -1;
    }

    public int getNumElementos(){
        return numElementos;
    }

    public int getNumCancionesTotal(){
        int suma = 0;
        IteradorC itC = this.getIterador();
        while(itC.hasNext())
            suma += itC.next().getNumCanciones();
        return suma;
    }

    public IteradorC getIterador(){
        return new IteradorC(inicio);
    }

    public double getMediaValoraciones(){
        if(this.vacia())
            return 0.0;
        else{
            double suma = 0;
            IteradorC itC = this.getIterador();
            while(itC.hasNext())
                suma += itC.next().getValoracion();
            return suma / this.getNumElementos();
        }
    }

    public Cantante getMayorValoracion(){
        if(this.vacia())
            return null;
        else{
            double mayor = 0.0;
            Cantante aux;
            Cantante c = inicio.getDato();
            IteradorC itC = this.getIterador();
            while(itC.hasNext()){
                aux = itC.next();
                if(aux.getValoracion() > mayor){
                    mayor = aux.getValoracion();
                    c = aux;
                }
            }
            return c;
        }
    }

    public void mostrar(){
        if(!this.vacia()){
            System.out.println(this.getNumElementos() + " cantantes:");
            int i = 1;
            IteradorC itC = this.getIterador();
            Cantante c;
            while(itC.hasNext()){
                c = itC.next();
                System.out.println(i + ". " + c.getNombre() + "   Valoración = " + c.getValoracion());
                c.mostrarCanciones();
                i++;
            }
            System.out.println("La media de las valoraciones de los cantantes es " + this.getMediaValoraciones());
            c = getMayorValoracion();
            System.out.println("La valoración más alta es " + c.getValoracion() + " del cantante " + c.getNombre());
            System.out.println("El número total de canciones es " + this.getNumCancionesTotal());
        }
        else
            System.out.println("La lista está vacía.");
    }

    public void mostrarCantante(int posicion){
        if(posicion < getNumElementos() && posicion >= 0){
            int i = 1;
            IteradorC itC = this.getIterador();
            while(itC.hasNext() && i < posicion){
                i++;
                itC.next();
            }
            Cantante c = itC.next();
            System.out.println("Nombre: " + c.getNombre() + ".    Valoración: " + c.getValoracion());
            c.mostrarCanciones();
        }
    }

    public void mostrarCanciones(){
        int i = 1;
        ListaOrdinal list;
        list = crearListaCanciones();
        Iterador it = list.getIterador();
        Cancion c;
        System.out.println(list.getNumElementos() + " canciones:");
        while(it.hasNext()){
            c = it.next();
            System.out.println(i + ". " + c.getNombre() + "    Valoración: " + c.getNota());
            i++;
        }
    }

    private ListaOrdinal crearListaCanciones(){
        ListaOrdinal list = new ListaOrdinal();
        IteradorC itC = this.getIterador();
        while(itC.hasNext())
            insertarEnListaCanciones(itC.next(),list);
        return list;
    }

    private void insertarEnListaCanciones(Cantante c, ListaOrdinal list) {
        Iterador it = c.getListaCanciones().getIterador();
        while(it.hasNext())
            list.insertarCancion(it.next());
    }

    public boolean contieneCancion(Cancion c){
        ListaOrdinal list;
        list = crearListaCanciones();
        return list.contieneCancion(c);
    }
}