package com.rodrigo.repuestos2;

public class Usuario {
    private int Id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Contrasenia;
    private String RContrasenia;
    private String Telefono;
    private String Genero;

    public Usuario(int id, String nombre, String apellido, String correo, String contrasenia, String RContrasenia, String telefono, String genero) {
        Id = id;
        Nombre = nombre;
        Apellido = apellido;
        Correo = correo;
        Contrasenia = contrasenia;
        this.RContrasenia = RContrasenia;
        Telefono = telefono;
        Genero = genero;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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

    public String getRContrasenia() {
        return RContrasenia;
    }

    public void setRContrasenia(String RContrasenia) {
        this.RContrasenia = RContrasenia;
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
                ", RContrasenia='" + RContrasenia + '\'' +
                ", Telefono='" + Telefono + '\'' +
                ", Genero='" + Genero + '\'' +
                '}';
    }
}
