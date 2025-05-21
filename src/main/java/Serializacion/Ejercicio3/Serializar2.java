package Serializacion.Ejercicio3;

import java.io.*;
import java.util.ArrayList;

public class Serializar2 {

    public static void main(String[] args) {

        Perro2 perro1 = new Perro2("Luna", "Pekinés",7);
        Perro2 perro2 = new Perro2("Sol", "Gran danés",65);
        Perro2 perro3 = new Perro2("Rayo", "Rottweiler",38);

        ArrayList<Perro2> listaPerros = new ArrayList<>();
        listaPerros.add(perro1);
        listaPerros.add(perro2);
        listaPerros.add(perro3);

        try {
            ObjectOutputStream perro_serializado = new ObjectOutputStream(new FileOutputStream("src/main/resources/EjerciciosSerializar/perros2.ser"));
            perro_serializado.writeObject(listaPerros);
            perro_serializado.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            ObjectInputStream leer_perro = new ObjectInputStream(new FileInputStream("src/main/resources/EjerciciosSerializar/perros2.ser"));
            ArrayList<Perro2> perros_leidos = (ArrayList<Perro2>) leer_perro.readObject();
            leer_perro.close();

            for (Perro2 p:perros_leidos) {
                System.out.println(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. Creando datos por defecto...");
            perrosDef();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha salido mal.");
            e.printStackTrace();
        }

    }

    private static void perrosDef() {
        ArrayList<Perro2> listaPerrosdef = new ArrayList<>();
        listaPerrosdef.add(new Perro2("Max", "Pastor Alemán", 30));
        listaPerrosdef.add(new Perro2("Tobby", "Golden", 25));

        try {
            ObjectOutputStream perro_serializado = new ObjectOutputStream(new FileOutputStream("src/main/resources/EjerciciosSerializar/perros2.ser"));
            perro_serializado.writeObject(listaPerrosdef);
            perro_serializado.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal.");
            e.printStackTrace();
        }

        for (Perro2 p:listaPerrosdef) {
            System.out.println(p);
        }
    }

}
