package com.rodrigo.repuestos2;

public class Utilidades {
    public static final String TABLA_USUARIO = "Usuario";
    public static final String CAMPO_ID = "Id";
    public static final String CAMPO_NOMBRE = "Nombre";
    public static final String CAMPO_APELLIDO = "Apellido";
    public static final String CAMPO_CORREO = "Correo";
    public static final String CAMPO_CONTRASENIA = "Contrasenia";
    public static final String CAMPO_RCONTRASENIA = "RContrasenia";
    public static final String CAMPO_TELEFONO = "Telefono";
    public static final String CAMPO_GENEROO = "Genero";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE"+" "+ TABLA_USUARIO+"("+
            CAMPO_ID+" INTEGER,"+CAMPO_NOMBRE+" TEXT,"+ CAMPO_APELLIDO+" TEXT,"+ CAMPO_CORREO +
            "TEXT,"+CAMPO_CONTRASENIA+" TEXT,"+CAMPO_RCONTRASENIA+"TEXT,"+CAMPO_TELEFONO+
        "TEXT,"+CAMPO_GENEROO+" TEXT)";

}
