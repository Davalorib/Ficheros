package Serializacion.Ejercicio4;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString @AllArgsConstructor
public class Perro3 implements Serializable {

    private String nombre;
    private String raza;
    private transient int peso;

}
