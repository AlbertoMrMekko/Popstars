package PopStarsPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ficheros {
    public Ficheros(){ }

    // ESTRUCTURA DEL FICHERO:
    // LOS CANTANTES EMPIEZAN POR -
    // LAS CANCIONES EMPIEZAN POR >
    // LAS NOTAS EMPIEZAN POR +
    // EJEMPLO:
    /*
        -Ava Max    +9.0
        >Torn   +10.0
        >So Am I    +8.0
        -Taylor Swift   +8.5
        >Delicate   +8.0
        >Calm down  +8.5
        >ME +9.0
     */

    public boolean leerFichero(ListaCalificada l){
        File f1;
        Scanner scanner = null;
        Cantante c = new Cantante("Nadie");
        Cancion cc;
        try {
            f1 = new File("POPSTARS.txt");//pruebas2.txt
            scanner = new Scanner(f1);
            String s;
            String[] s2;
            while (scanner.hasNextLine()){
                s = scanner.nextLine();
                if(s.charAt(0) == '-'){
                    s = s.substring(1);
                    s2 = s.split("\t\\+");
                    c = new Cantante(s2[0]);
                    l.insertarCantante(c);
                }
                else if(s.charAt(0) == '>'){
                    s = s.substring(1);
                    s2 = s.split("\t\\+");
                    double nota = Double.parseDouble(s2[1]);
                    cc = new Cancion(s2[0],nota);
                    c.nuevaCancion(cc);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }finally {
            if(scanner != null)
                scanner.close();
        }
        l.mostrar();
        return true;
    }

    public boolean escribirFichero(ListaCalificada l) throws IOException {
        FileWriter f2 = null;
        IteradorC itC = l.getIterador();
        Cantante c;
        try{
            f2 = new FileWriter("POPSTARS.txt");
            while(itC.hasNext()){
                c = itC.next();
                f2.write("-" + c.getNombre() + "\t+" + c.getValoracion() + "\n");
                if(c.getNumCanciones() > 0)
                    escribirCanciones(f2, c);
            }
        }catch (IOException e){
            System.out.println("<<< " + e.getMessage() + " >>>");
            return false;
        }finally {
            if(f2 != null)
                f2.close();
        }
        return true;
    }

    private void escribirCanciones(FileWriter f2, Cantante c){
        Iterador it = c.getListaCanciones().getIterador();
        Cancion cc;
        try{
            while (it.hasNext()){
                cc = it.next();
                f2.write(">" + cc.getNombre() + "\t+" + cc.getNota() + "\n");
            }
        }catch (IOException e){
            System.out.println("<<< " + e.getMessage() + " >>>");
        }
    }
}
