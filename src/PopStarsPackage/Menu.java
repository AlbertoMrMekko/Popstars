package PopStarsPackage;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public Menu(){ }

    public void menuPrincipal() throws IOException {
        Ficheros f = new Ficheros();
        ListaCalificada l = new ListaCalificada();
        if(f.leerFichero(l)) {
            try{
                Scanner scanner = new Scanner(System.in);
                int num;
                boolean end = false;
                do{
                    do{
                        System.out.println("---MENÚ---");
                        System.out.println("[1] Añadir cantante         [6] Buscar cantante");
                        System.out.println("[2] Añadir canción          [7] Buscar canción");
                        System.out.println("[3] Mostrar cantante        [8] Borrar cantante");
                        System.out.println("[4] Mostrar lista canciones [9] Borrar canción");
                        System.out.println("[5] Mostrar todo            [0] Guardar y salir");
                        num = scanner.nextInt();
                        scanner.nextLine();
                    }while(num < 0 || num > 9);
                    switch(num){
                        case 0: end = true;
                            break;
                        case 1: {
                            String nombre;
                            System.out.print("Indique el nombre del cantante: ");
                            nombre = scanner.nextLine();
                            Cantante c = new Cantante(nombre);
                            if(!l.contieneCantante(c)){
                                l.insertarCantante(c);
                                System.out.println("El cantante ha sido añadido con éxito.");
                            }
                            else
                                System.out.println("El cantante ya estaba en la lista.");
                        }
                            break;
                        case 2: {
                            String nombre;
                            double nota;
                            System.out.print("Indique el nombre del cantante: ");
                            Cantante c = new Cantante(scanner.nextLine());
                            if(l.contieneCantante(c)){
                                int pos;
                                pos = l.posicionCantante(c);
                                c = l.getElemento(pos);
                                System.out.print("Indique el nombre de la canción: ");
                                nombre = scanner.nextLine();
                                System.out.print("Indique la valoración de la canción: ");
                                nota = Double.parseDouble(scanner.nextLine());
                                Cancion cc = new Cancion(nombre,nota);
                                if(!c.getListaCanciones().contieneCancion(cc)){
                                    c.nuevaCancion(cc);
                                    System.out.println("La canción ha sido añadida con éxito.");
                                }
                                else
                                    System.out.println("La canción ya se encuentra en la lista.");
                            }
                            else
                                System.out.println("El cantante no se encuentra en la lista.");
                        }
                            break;
                        case 3: {
                            System.out.print("Indique el nombre del cantante: ");
                            Cantante c = new Cantante(scanner.nextLine());
                            if(l.contieneCantante(c)){
                                int pos;
                                pos = l.posicionCantante(c);
                                c = l.getElemento(pos);
                                c.mostrarCanciones();
                            }
                            else
                                System.out.println("El cantante no se encuentra en la lista.");
                        }
                            break;
                        case 4: l.mostrarCanciones();
                            break;
                        case 5: l.mostrar();
                            break;
                        case 6: {
                            String nombre;
                            System.out.print("Indique el nombre del cantante: ");
                            nombre = scanner.nextLine();
                            Cantante c = new Cantante(nombre);
                            if(l.contieneCantante(c))
                                System.out.println("El cantante está en la lista.");
                            else
                                System.out.println("El cantante no está en la lista.");
                        }
                            break;
                        case 7: {
                            String nombre;
                            System.out.print("Indique el nombre de la canción: ");
                            nombre = scanner.nextLine();
                            Cancion c = new Cancion(nombre);
                            if(l.contieneCancion(c))
                                System.out.println("La canción está en la lista.");
                            else
                                System.out.println("La canción no está en la lista.");
                        }
                            break;
                        case 8: {
                            String nombre;
                            System.out.print("Indique el nombre del cantante: ");
                            nombre = scanner.nextLine();
                            Cantante c = new Cantante(nombre);
                            if(l.contieneCantante(c)){
                                l.borrarCantante(c);
                                System.out.println("El cantante ha sido borrado con éxito.");
                            }
                            else
                                System.out.println("El cantante no está en la lista.");
                        }
                            break;
                        case 9: { // NO BORRA LAS CANCIONES. PUEDE SER PQ NO LAS BORRE DE LA LISTA l, O PQ EL METODO eliminarCancion(c) NO SE ACTIVA
                            String nombre;
                            System.out.print("Indique el nombre del cantante: ");
                            Cantante c = new Cantante(scanner.nextLine());
                            if(l.contieneCantante(c)) {
                                int pos;
                                pos = l.posicionCantante(c);
                                c = l.getElemento(pos);
                                System.out.print("Indique el nombre de la canción: ");
                                nombre = scanner.nextLine();
                                Cancion cc = new Cancion(nombre);
                                if(c.getListaCanciones().contieneCancion(cc)){
                                    c.eliminarCancion(cc);
                                    System.out.println("La canción ha sido borrada con éxito.");
                                }
                                else
                                    System.out.println("La canción no está en la lista.");
                            }
                                //IteradorC itC = l.getIterador();
                                //while(itC.hasNext()){

                                //}
                            //}
                            else
                                System.out.println("El cantante no se encuentra en la lista.");
                        }
                    }
                }while(!end);
                scanner.close();
            }catch (Exception e){
                System.out.println("<<<  Error >>>");
            }finally {
                if(f.escribirFichero(l))
                    System.out.println("Guardado con éxito.");
            }
        }
        else
            System.out.println("El fichero no se ha abierto correctamente.");
    }
}