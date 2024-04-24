package sistema.utils;

import java.util.*;
import sistema.Biblioteca;
import java.time.LocalDate;
import usuarios.*;
import usuarios.utils.*;

public class DatosComun {

    public static ArrayList<String> obtenerDatosComun(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datos = new ArrayList<>();
        System.out.println("Ingrese los siguientes datos para " + rol + ":");
        System.out.print("Nombre: ");
        datos.add(scanner.nextLine());
        System.out.print("Apellido: ");
        datos.add(scanner.nextLine());
        datos.add(obtenerNumeroTelefono());
        datos.add(obtenerNombreUsuario());
        System.out.print("Contraseña: ");
        datos.add(scanner.nextLine());
        return datos;
    }

    public static String obtenerNumeroTelefono() {
        Scanner scanner = new Scanner(System.in);
        String telefono;
        do {
            System.out.print("Número de teléfono: ");
            telefono = scanner.nextLine();
            if (telefonoExiste(telefono)) {
                System.out.println("El número de teléfono ya existe. Intente otro.");
            } else {
                break;
            }
        } while (true);
        return telefono;
    }

    private static boolean telefonoExiste(String telefono) {
        HashMap<Rol, ArrayList<Usuario>> usuarios = Biblioteca.getUsuarios();
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNumeroTelefono().equals(telefono)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String obtenerNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nombreUsuario;
        do {
            System.out.print("Nombre de usuario: ");
            nombreUsuario = scanner.nextLine();
            if (nombreUsuarioExiste(nombreUsuario)) {
                System.out.println("El nombre de usuario ya existe. Intente otro.");
            } else {
                break;
            }
        } while (true);
        return nombreUsuario;
    }

    public static boolean nombreUsuarioExiste(String nombreUsuario) {
        HashMap<Rol, ArrayList<Usuario>> usuarios = Biblioteca.getUsuarios();
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String obtenerDatoEspecifico(String dato) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese " + dato + ": ");
        return scanner.nextLine();
    }

    public static double obtenerSalario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Salario: ");
        return scanner.nextDouble();
    }

    public static LocalDate obtenerFecha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fecha = scanner.nextLine();
        return LocalDate.parse(fecha);
    }
}
