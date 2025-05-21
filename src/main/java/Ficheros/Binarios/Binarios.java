package Ficheros.Binarios;

import java.io.*;

public class Binarios {

    public static void main(String[] args) {

        //DataOutputStream
        //FileOutputStream

        try {
            DataOutputStream fichario_binario = new DataOutputStream(new FileOutputStream("src/main/resources/Binario/archivo.bin"));
            fichario_binario.writeBoolean(false);
            fichario_binario.writeDouble(3.1415);
            fichario_binario.writeInt(4);
            fichario_binario.writeUTF("Hola");
            fichario_binario.close();
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            DataInputStream leer = new DataInputStream(new FileInputStream("src/main/resources/Binario/archivo.bin"));
            boolean si = leer.readBoolean();
            double pi = leer.readDouble();
            int num = leer.readInt();
            String linea = leer.readUTF();
            leer.close();
            System.out.println(si+" "+pi+" "+num+" "+linea);
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

        try {
            FileInputStream leer_a_ciegas = new FileInputStream("src/main/resources/Binario/archivo.bin");
            int bytes;
            while((bytes = leer_a_ciegas.read()) != -1){
                System.out.print((char) bytes);
            }
        } catch (IOException e) {
            System.out.println("Algo ha salido mal");
            e.printStackTrace();
        }

    }

}
