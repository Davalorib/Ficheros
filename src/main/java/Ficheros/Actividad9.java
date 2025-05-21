package Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Actividad9 {

    public static void main(String[] args) {

        try {
            File archivo1 = new File("src/main/resources/lorem.txt");
            File archivo2 = new File("src/main/resources/lorem_temp.txt");

            Scanner leer = new Scanner(archivo1);
            BufferedWriter escribir = new BufferedWriter(new FileWriter(archivo2));

            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String[] palabras = linea.split("[,. ]");

                for (int i = 0; i < palabras.length; i++) {
                    if (!palabras[i].isEmpty()) {
                        palabras[i] = palabras[i].substring(0, 1).toUpperCase() + palabras[i].substring(1).toLowerCase();
                    }
                }

                StringBuilder lineaModificada = new StringBuilder();
                for (String s:palabras) {
                    if (!s.isEmpty()) {
                        if (lineaModificada.length() > 0) {
                            lineaModificada.append(" ");
                        }
                        lineaModificada.append(s);
                    }
                }
                escribir.write(lineaModificada.toString());
                escribir.newLine();
            }

            leer.close();
            escribir.close();

            if (archivo1.delete()) {
                archivo2.renameTo(archivo1);
                System.out.println("Perfecto, ahora empiezan todas las palabras por mayúscula");
            } else {
                System.out.println("No se ha podido reemplazar el archivo original");
            }

        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }
    }
}
