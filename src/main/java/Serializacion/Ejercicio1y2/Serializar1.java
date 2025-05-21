package Serializacion.Ejercicio1y2;

import java.io.*;
import java.util.ArrayList;

public class Serializar1 {

    public static void main(String[] args) {

        Perro1 perro1 = new Perro1("Luna", "Pekinés",7);
        Perro1 perro2 = new Perro1("Sol", "Gran danés",65);
        Perro1 perro3 = new Perro1("Rayo", "Rottweiler",38);

        ArrayList<Perro1> listaPerros = new ArrayList<>();
        listaPerros.add(perro1);
        listaPerros.add(perro2);
        listaPerros.add(perro3);

        try {
            ObjectOutputStream perro_serializado = new ObjectOutputStream(new FileOutputStream("src/main/resources/EjerciciosSerializar/perros.ser"));
            perro_serializado.writeObject(listaPerros);
            perro_serializado.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            ObjectInputStream leer_perro = new ObjectInputStream(new FileInputStream("src/main/resources/EjerciciosSerializar/perros.ser"));
            ArrayList<Perro1> perros_leidos = (ArrayList<Perro1>) leer_perro.readObject();
            leer_perro.close();

            for (Perro1 p:perros_leidos) {
                System.out.println(p);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

    }

}
