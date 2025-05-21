package Ficheros;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LeerScanner {

    public static void main(String[] args) {

        File fichero = new File("src/main/resources/prueba.txt");

        try {
            Scanner lector = new Scanner(fichero);

            while (lector.hasNextLine()){
                System.out.println("Línea: "+lector.nextLine());
                String linea = lector.nextLine();
                String[] palabras = linea.split(",");
                System.out.println("Alumno: " + palabras[0]+" con nota: "+palabras[1]);
            }
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

    }

}
