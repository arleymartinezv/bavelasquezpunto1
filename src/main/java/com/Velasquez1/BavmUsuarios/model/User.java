package com.Velasquez1.BavmUsuarios.model;

public class User {
    private Long id;
    private String nombre;
    private String correo;
    private int edad;

    public User() {}

    public User(Long id, String nombre, String correo, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.edad = edad;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
}
