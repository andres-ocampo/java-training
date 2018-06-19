package co.com.s4n.training.java;

import lombok.Data;

@Data
public class Person {

    private int edad;
    private String nombre;
    private String apellido;
    private String correo;

    public Person(int edad, String nombre, String apellido, String correo) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }
}
