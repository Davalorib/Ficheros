package Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Actividad4 {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        System.out.print("¿Cuántos ficheros quieres?: ");
        int num = ent.nextInt();
        System.out.print("¿En qué carpeta los quieres?: ");
        ent.nextLine();
        String carpeta = ent.next();

        if (new File(carpeta).exists()) {

            for (int i = 1; i <= num; i++) {
                File fichero = new File(carpeta + "/fichero(" + i + ").txt");
                try {
                    fichero.createNewFile();
                    System.out.println("Fichero " + fichero.getName() + " creado.");
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
