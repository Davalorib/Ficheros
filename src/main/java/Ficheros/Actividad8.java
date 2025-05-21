package Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad8 {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        File carpeta = new File("src/main/resources");

        BufferedWriter a;

        System.out.print("¿Cuántos ficheros quieres?: ");
        int num = ent.nextInt();

        if (new File(String.valueOf(carpeta)).exists()) {

            for (int i = 1; i <= num; i++) {
                File fichero = new File(carpeta + "/fichero(" + i + ").txt");
                try {
                    fichero.createNewFile();
                    System.out.println("Fichero " + fichero.getName() + " creado.");
                    a = new BufferedWriter(new FileWriter(carpeta + "/" + fichero.getName()));
                    a.write("Este es el fichero nombre " + fichero.getName());
                    a.close();
                } catch (IOException e) {
                    System.out.println("Algo ha ido mal.");
                    e.printStackTrace();
                }
            }

        } else {
            System.out.println("Esa ruta no existe");
        }

    }

}
