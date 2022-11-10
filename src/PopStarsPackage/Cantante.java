package PopStarsPackage;

public class Cantante {
    private String nombre;
    private double valoracion;
    private ListaOrdinal canciones;

    public Cantante(String nombre){
        this.nombre = nombre;
        valoracion = 0.0;
        canciones = new ListaOrdinal();
    }

    public String getNombre() { return nombre; }

    public double getValoracion(){ return valoracion; }

    public int getNumCanciones(){ return canciones.getNumElementos(); }

    public void nuevaCancion(Cancion c){
        if(c != null){
            this.canciones.insertarCancion(c);
            this.actualizarValoracion(canciones);
        }
    }

    public void eliminarCancion(Cancion c){
        if(c != null) {
            this.canciones.borrarCancion(c);
            this.actualizarValoracion(canciones);
        }
    }

    public Cancion getCancion(int posicion){
        return canciones.getElemento(posicion);
    }

    public void actualizarValoracion(ListaOrdinal l){
        if(l.vacia())
            valoracion = 0.0;
        else{
            double suma = 0.0;
            Iterador it = l.getIterador();
            while(it.hasNext()){
                suma += it.next().getNota();
            }
            valoracion = suma / getNumCanciones();
        }
    }

    public void mostrarCanciones(){
        System.out.println("  " + this.getNumCanciones() + " canciones:");
        if(getNumCanciones() != 0){
            Cancion aux;
            Iterador it = this.canciones.getIterador();
            while(it.hasNext()){
                aux = it.next();
                System.out.println("   -" + aux.getNombre() + "   Valoración = " + aux.getNota());
            }
        }
    }

    public ListaOrdinal getListaCanciones(){
        return canciones;
    }
}
