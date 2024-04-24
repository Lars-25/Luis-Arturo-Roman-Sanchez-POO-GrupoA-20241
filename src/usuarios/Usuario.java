package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;

public class Usuario {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimineto;
    private LocalDate fechaRegistro;
    private String contrasena;
    private String nombreUsuario;
    private String numeroTelefono;



    public Usuario(String nombre, String apellido, Rol rol, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) 
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = nextID;
        nextID++;
        this.numeroTelefono = numeroTelefono;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.fechaNacimineto = fechaNacimiento;
        this.fechaRegistro = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("ID: %d\nNombre completo: %s %s\nRol: %s\nFecha de registro: %s\n", id, nombre, apellido, rol, fechaRegistro.toString());
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Rol getRol() {
        return rol;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public String getNumeroTelefono(){
        return numeroTelefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }    

}
