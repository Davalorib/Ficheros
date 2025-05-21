package Ficheros;

import java.io.File;
import java.util.Scanner;

public class Actividad5 {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        File carpeta = new File("src/main/resources");

        //1ª opción listar solo nombres
        String ficheros[] = carpeta.list();

        if (ficheros!=null && ficheros.length>0){
            for(String fichero:ficheros){
                System.out.println(fichero);
            }
        } else {
            System.out.println("Ese directorio ta vacío");
        }

        System.out.println();
        //2ª opción listar objetos de tipo file
        File listaFicheros[] = carpeta.listFiles();

        if (listaFicheros != null && listaFicheros.length>0){
            for(File fichero:listaFicheros){
                if (fichero.isFile()) System.out.println("Fichero con nombre "+fichero.getName()+" con tamaño "+fichero.length()+" bytes.");
            }
        }else{
            System.out.println("El directorio ta vacío.");
        }

        System.out.println("Dame la extensión que quieres listar: ");
        listarArchivosPorExtension(carpeta,ent.next());
    }

    public static void listarArchivosPorExtension(File c, String e) {

        File listaFicheros[] = c.listFiles();

        if (listaFicheros != null && listaFicheros.length>0) {
            for (File f:listaFicheros) {
                if (f.isFile() && f.getName().endsWith(e)) System.out.println("Fichero con nombre "+f.getName()+" con tamaño "+f.length()+" bytes.");
            }
        } else {
            System.out.println("El directorio ta vacío.");
        }
    }

}
