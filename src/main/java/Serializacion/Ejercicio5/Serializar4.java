package Serializacion.Ejercicio5;

import java.io.*;
import java.util.ArrayList;

public class Serializar4 {

    public static void main(String[] args) {

        Empleado e1 = new Empleado("César", 4000);
        Empleado e2 = new Empleado("Roberto", 1800);
        Empleado e3 = new Empleado("Mauro", 1800);
        Jefe j1 = new Jefe("David", 10000,"CEO");

        ArrayList<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        listaEmpleados.add(j1);

        try {
            ObjectOutputStream empleados_serializados = new ObjectOutputStream(new FileOutputStream("src/main/resources/EjerciciosSerializar/empleados.ser"));
            empleados_serializados.writeObject(listaEmpleados);
            empleados_serializados.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            ObjectInputStream leer_empleado = new ObjectInputStream(new FileInputStream("src/main/resources/EjerciciosSerializar/empleados.ser"));
            ArrayList<Empleado> empleados_leidos = (ArrayList<Empleado>) leer_empleado.readObject();
            leer_empleado.close();

            for (Empleado e:empleados_leidos) {
                System.out.println(e);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

    }

}
