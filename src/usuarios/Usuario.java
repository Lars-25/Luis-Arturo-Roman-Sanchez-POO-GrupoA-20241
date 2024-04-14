package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;


public class Usuario {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private String contrasena;
    private String nombreUsuario;
    private LocalDate fechaDeRegistro;

    public Usuario(String nombre, String apellido, Rol rol, LocalDate fechaDeRegistro, String contrasena, String nombreUsuario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = nextID;
        nextID++;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.fechaDeRegistro = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("ID: %d\nNombre completo: %s %s\nRol: %s\n", id, nombre, apellido, rol);
    }

    public String getContraseña(){
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Rol getRol() {
        return rol;
    }

}