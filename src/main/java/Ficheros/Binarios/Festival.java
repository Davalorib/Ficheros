package Ficheros.Binarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter @Setter @ToString @AllArgsConstructor
public class Festival implements Serializable {

    private String nombre;
    private String fecha;
    private int aforo;
    private String lugar;

}
