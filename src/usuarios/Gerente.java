package usuarios;

import usuarios.utils.Rol;
import java.time.LocalDate;
import sistema.Biblioteca;
import sistema.utils.DatosComun;
import java.util.*;

public class Gerente extends Usuario {
    private double salario;
    private String rfc;
    private String curp;

    public Gerente(String nombre, String apellido, Rol rol, String curp, String rfc, double salario, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.GERENTE, fechaRegistro, fechaNacimiento, numeroTelefono, contrasena, nombreUsuario);
        this.curp = curp;
        this.rfc = rfc;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return String.format("%sCURP: %s\nRFC: %s\nFecha de contratación: %s\nSalario: $%.2f\n", super.toString(), this.curp, this.rfc, this.getFechaRegistro().toString(), this.salario);
    }

    public String getCurp() {
        return curp;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSalario(){
        return salario;
    }


    // metodos


    public static void registrarGerente() {
        ArrayList<String> datosComun = DatosComun.obtenerDatosComun(Rol.GERENTE);
        String curp = DatosComun.obtenerDatoEspecifico("CURP para Gerente");
        String rfc = DatosComun.obtenerDatoEspecifico("RFC para Gerente");
        double salario = DatosComun.obtenerSalario();
        LocalDate fechaNacimiento = DatosComun.obtenerFecha();

        Gerente nuevoGerente = new Gerente(
            datosComun.get(0), // nombre
            datosComun.get(1), // apellido
            Rol.GERENTE,
            curp,
            rfc,
            salario,
            LocalDate.now(), // fecha de registro
            fechaNacimiento,
            datosComun.get(2), // numeroTelefono
            datosComun.get(4), // contrasena
            datosComun.get(3)  // nombreUsuario
        );
        Biblioteca.agregarUsuario(Rol.GERENTE, nuevoGerente);
    }

    public static void eliminarGerente(String nombreUsuario) {
        if (DatosComun.nombreUsuarioExiste(nombreUsuario)) {
            Biblioteca.eliminarUsuario(Rol.GERENTE, nombreUsuario);
        } else {
            System.out.println("No se encontró un Gerente con ese nombre de usuario.");
        }
    }

    public static void mostrarTodosLosUsuarios() {
        HashMap<Rol, ArrayList<Usuario>> todosLosUsuarios = Biblioteca.getUsuarios();

        if (todosLosUsuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }

        System.out.println("Listado de todos los usuarios:");
        for (Rol rol : todosLosUsuarios.keySet()) {
            System.out.println("\nRol: " + rol);
            ArrayList<Usuario> usuariosPorRol = todosLosUsuarios.get(rol);
            for (Usuario usuario : usuariosPorRol) {
                Biblioteca.mostrarInformacionUsuario(usuario);
            }
        }

    }
    
}
