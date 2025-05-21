package Ficheros.Binarios;

import java.io.*;

public class Serializar {

    public static void main(String[] args) {

        Festival milenial = new Festival("Nostalgia Milenial","2025-9-24",50,"Alicante");

        try {
            ObjectOutputStream objeto_serializado = new ObjectOutputStream(new FileOutputStream("src/main/resources/festival.ser"));
            objeto_serializado.writeObject(milenial);
            objeto_serializado.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            ObjectInputStream leer_objeto = new ObjectInputStream(new FileInputStream("src/main/resources/festival.ser"));
            Festival milenials_leido = (Festival) leer_objeto.readObject();
            leer_objeto.close();
            System.out.println("Nombre del festival: "+milenials_leido.getNombre()+" - Fecha: "+milenials_leido.getFecha()+" - Aforo: "+milenials_leido.getAforo()+" - Lugar: "+milenials_leido.getLugar());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }
    }

}
