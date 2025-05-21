package Serializacion.Ejercicio5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString @AllArgsConstructor
public class Empleado implements Serializable {

    private String nombre;
    private double salario;

}
