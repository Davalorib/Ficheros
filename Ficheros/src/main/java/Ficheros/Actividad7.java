package Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Actividad7 {

    public static void main(String[] args) {

        try {
            File archivo = new File("src/main/resources/lorem.txt");
            Scanner leer = new Scanner(archivo);

            Map<String, Integer> mapita = new HashMap<>();

            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String[] palabras = linea.split("[,. ]");

                for (String s:palabras) {
                    mapita.put(s.toLowerCase(), mapita.getOrDefault(s.toLowerCase(), 0)+1);
                }
            }

            leer.close();

            for (Map.Entry<String, Integer> e:mapita.entrySet()) {
                System.out.println(e.getKey()+": "+e.getValue()+(e.getValue() == 1 ? " vez" : " veces"));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            e.printStackTrace();
        }
    }
}
