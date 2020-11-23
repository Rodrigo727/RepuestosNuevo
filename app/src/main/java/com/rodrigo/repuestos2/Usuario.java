package com.rodrigo.repuestos2;

public class Usuario {
    private String Id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Contrasenia;
    private String Telefono;
    private String Genero;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String apellido, String correo, String contrasenia, String telefono, String genero) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Contrasenia = contrasenia;
        Telefono = telefono;
        Genero = genero;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        Contrasenia = contrasenia;
    }


    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Correo='" + Correo + '\'' +
                ", Contrasenia='" + Contrasenia + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
