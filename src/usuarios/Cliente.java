package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;
import sistema.Biblioteca;
import sistema.utils.DatosComun;
import java.util.*;


public class Cliente extends Usuario {
    private String curp;
    
    public Cliente(String nombre, String apellido, Rol rol, String curp, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.CLIENTE, fechaRegistro, fechaNacimiento, numeroTelefono, contrasena, nombreUsuario);
        this.curp = curp;
    }

    @Override
    public String toString(){
        return String.format("%sCURP: %s\nFecha de Registro: %s\n", super.toString(), this.curp, this.getFechaRegistro().toString());
    }

    public String getCurp() {
        return curp;
    }

    // Metodos


    public static void registrarCliente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String curp = DatosComun.obtenerDatoEspecifico("CURP");
        LocalDate fechaNacimiento = DatosComun.obtenerFecha();

        Cliente nuevoCliente = new Cliente(
            datosComun.get(0), // nombre
            datosComun.get(1), // apellido
            Rol.CLIENTE,
            curp,
            LocalDate.now(), // fecha de registro
            fechaNacimiento,
            datosComun.get(2), // numeroTelefono
            datosComun.get(4), // contrasena
            datosComun.get(3)  // nombreUsuario
        );

        Biblioteca.agregarUsuario(Rol.CLIENTE, nuevoCliente);
    }

    public static void eliminarCliente(String nombreUsuario) {
        if (DatosComun.nombreUsuarioExiste(nombreUsuario)) {
            Biblioteca.eliminarUsuario(Rol.CLIENTE, nombreUsuario);
        } else {
            System.out.println("No se encontró un cliente con ese nombre de usuario.");
        }
    }
    
}
