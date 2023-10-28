package org.example;

public class Alumno {

    private String nombre;
    private String apellidos;
    private String dni;
    private float nota;

    public Alumno(String nombre, String apellidos, String dni, float nota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    // TODO
    // Crear todos los atributos (Nombre, apellidos, dni, nota)

    // TODO
    // Crear el constructor

    // TODO
    // Crear todos los métodos getters y setters
}
