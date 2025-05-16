package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Actividad6 {

    public static void main(String[] args) {

        Scanner ent = new Scanner(System.in);

        File carpeta = new File("src/main/resources");
        Map<String, Integer> mapita = new HashMap<>();

        System.out.print("Dame la palabra a buscar: ");
        String palabra = ent.nextLine().toLowerCase();

        try {
            BufferedReader leer = new BufferedReader(new FileReader(carpeta + "/lorem.txt"));
            String linea;

            while ((linea = leer.readLine()) != null) {
                String[] palabras = linea.split("[,. ]");
                for (String s:palabras) {
                    mapita.put(s.toLowerCase(), mapita.getOrDefault(s.toLowerCase(),0)+1);
                }
            }

            System.out.println(palabra+": "+mapita.getOrDefault(palabra, 0)+(mapita.getOrDefault(palabra,0) == 1 ? " vez" : " veces"));
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

    }
}