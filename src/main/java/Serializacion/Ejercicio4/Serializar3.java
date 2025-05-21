package Serializacion.Ejercicio4;

import java.io.*;
import java.util.HashMap;
import java.util.TreeMap;

public class Serializar3 {

    public static void main(String[] args) {

        Perro3 perro1 = new Perro3("Luna", "Pekinés",7);
        Perro3 perro2 = new Perro3("Sol", "Gran danés",65);
        Perro3 perro3 = new Perro3("Rayo", "Rottweiler",38);

        HashMap<String, Perro3> mapitaPerros = new HashMap<>();
        mapitaPerros.put("Pekinés",perro1);
        mapitaPerros.put("Gran danés",perro2);
        mapitaPerros.put("Rottweiler",perro3);

        try {
            ObjectOutputStream mapita_serializado = new ObjectOutputStream(new FileOutputStream("src/main/resources/EjerciciosSerializar/mapa.ser"));
            mapita_serializado.writeObject(mapitaPerros);
            mapita_serializado.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            ObjectInputStream leer_mapita = new ObjectInputStream(new FileInputStream("src/main/resources/EjerciciosSerializar/mapa.ser"));
            HashMap<String,Perro3> mapita_leido = (HashMap<String,Perro3>) leer_mapita.readObject();
            leer_mapita.close();

            TreeMap<String,Perro3> mapita_ordenado = new TreeMap<>(mapita_leido);
            for (String m:mapita_ordenado.keySet()) {
                System.out.println("Clave: "+m+" - "+mapita_ordenado.get(m));
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

    }

}
