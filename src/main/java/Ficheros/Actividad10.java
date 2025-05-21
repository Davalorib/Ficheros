package Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad10 {

    public static void main(String[] args) {

        try {
            File archivo1 = new File("src/main/resources/archivo1.txt");
            File archivo2 = new File("src/main/resources/archivo2.txt");
            File archivoJunto = new File("src/main/resources/archivoJuntado.txt");

            Scanner leer1 = new Scanner(archivo1);
            Scanner leer2 = new Scanner(archivo2);
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivoJunto));

            while (leer1.hasNextLine() || leer2.hasNextLine()) {
                if (leer1.hasNextLine()) {
                    String palabra1 = leer1.next();
                    escribir.write(palabra1 + " ");
                }

                if (leer2.hasNextLine()) {
                    String palabra2 = leer2.next();
                    escribir.write(palabra2 + " ");
                }
            }

            leer1.close();
            leer2.close();
            escribir.close();

            System.out.println("Archivos combinados");

        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }
    }
}
