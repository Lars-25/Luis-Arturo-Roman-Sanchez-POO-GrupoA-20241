package Usuarios;
import java.time.LocalDate;
import Usuarios.utils.Rol;


public class Cliente extends Usuario {
    private LocalDate fechaDeRegistro;

    public Cliente(String nombre, String apellido, Rol rol, String contrasena, LocalDate fechaDeRegistro, String nombreUsuario) {
        super(nombre, apellido, Rol.CLIENTE, fechaDeRegistro, contrasena, nombreUsuario);
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    @Override
    public String toString(){
        return String.format("%sFecha de Registro %s\n", super.toString(), fechaDeRegistro.toString());
    }
    
}