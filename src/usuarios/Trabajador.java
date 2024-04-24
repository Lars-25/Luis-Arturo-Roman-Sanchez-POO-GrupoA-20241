package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;
import sistema.Biblioteca;
import sistema.utils.DatosComun;
import java.util.*;

public class Trabajador extends Usuario {
    private String rfc;
    private double salario;


    public Trabajador(String nombre, String apellido, Rol rol, String rfc, double salario, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.TRABAJADOR, fechaRegistro, fechaNacimiento, numeroTelefono, contrasena, nombreUsuario);
        this.rfc = rfc;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return String.format("%sRFC: %s\nFecha de contratación: %s\nSalario: $%.2f\n", super.toString(), this.rfc, this.getFechaRegistro().toString(), this.salario);
    }

    public String getRfc() {
        return rfc;
    }

    public double getSalario(){
        return salario;
    }

    // Metodos


    public static void registrarTrabajador() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);
        String rfc = DatosComun.obtenerDatoEspecifico("RFC");
        double salario = DatosComun.obtenerSalario();
        LocalDate fechaNacimiento = DatosComun.obtenerFecha();

        Trabajador nuevoTrabajador = new Trabajador(
            datosComun.get(0), // nombre
            datosComun.get(1), // apellido
            Rol.TRABAJADOR,
            rfc,
            salario,
            LocalDate.now(), // fecha de registro
            fechaNacimiento,
            datosComun.get(2), // numeroTelefono
            datosComun.get(4), // contrasena
            datosComun.get(3)  // nombreUsuario
        );

        Biblioteca.agregarUsuario(Rol.TRABAJADOR, nuevoTrabajador);
    }

    public static void eliminarTrabajador(String nombreUsuario) {
        if (DatosComun.nombreUsuarioExiste(nombreUsuario)) {
            Biblioteca.eliminarUsuario(Rol.TRABAJADOR, nombreUsuario);
        } else {
            System.out.println("No se encontró un trabajador con ese nombre de usuario.");
        }
    }

    
}
