package Ficheros;

import java.io.File;
import java.io.IOException;

public class Actividad1y2y3 {

    public static void main(String[] args) {

        File fichero = new File("src/main/resources/hola.txt");

        try {
            fichero.createNewFile();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        System.out.println("Tamaño del fichero: "+fichero.length());
        System.out.println("Ruta del fichero: "+fichero.getAbsolutePath());

        File carpeta = new File("src/main/resources/DavidElMalo");

        carpeta.mkdir();

        if(carpeta.exists()) System.out.println("Tu carpeta '"+carpeta.getName()+"' existe");
        else System.out.println("Tu carpeta '"+carpeta.getName()+"' no existe");

        fichero.delete();

        if(fichero.exists()) System.out.println("Tu fichero '"+fichero.getName()+"' existe");
        else System.out.println("Tu fichero '"+fichero.getName()+"' no existe");
    }

}
