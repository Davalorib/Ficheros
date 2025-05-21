package Serializacion.Ejercicio3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString @AllArgsConstructor
public class Perro2 implements Serializable {

    private String nombre;
    private String raza;
    private transient int peso;

}
