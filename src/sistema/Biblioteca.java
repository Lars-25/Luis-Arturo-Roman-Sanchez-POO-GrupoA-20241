package sistema;

import usuarios.*;
import usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    private HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();

    public Biblioteca() {
        for (Rol rol : Rol.values()) {
            usuarios.put(rol, new ArrayList<>());
        }
    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        return usuarios.values().stream()
                       .flatMap(ArrayList::stream)
                       .filter(u -> u.getNombreUsuario().equals(nombreUsuario) && u.getContrasena().equals(contrasena))
                       .findFirst()
                       .orElse(null);
    }

    public void registrarCliente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.CLIENTE);
        String curp = obtenerDatoEspecifico("CURP");
        LocalDate fechaNacimiento = obtenerFecha();

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

        usuarios.get(Rol.CLIENTE).add(nuevoCliente);
    }

    public void registrarTrabajador() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.TRABAJADOR);
        String rfc = obtenerDatoEspecifico("RFC");
        double salario = obtenerSalario();
        LocalDate fechaNacimiento = obtenerFecha();

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

        usuarios.get(Rol.TRABAJADOR).add(nuevoTrabajador);
    }

    public void registrarGerente() {
        ArrayList<String> datosComun = obtenerDatosComun(Rol.GERENTE);
        String curp = obtenerDatoEspecifico("CURP para Gerente");
        String rfc = obtenerDatoEspecifico("RFC para Gerente");
        double salario = obtenerSalario();
        LocalDate fechaNacimiento = obtenerFecha();

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

        usuarios.get(Rol.GERENTE).add(nuevoGerente);
    }

    private ArrayList<String> obtenerDatosComun(Rol rol) {
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

    private String obtenerNumeroTelefono() {
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

    private boolean telefonoExiste(String telefono) {
        return usuarios.values().stream()
                       .flatMap(ArrayList::stream)
                       .anyMatch(u -> u.getNumeroTelefono().equals(telefono));
    }

    private String obtenerNombreUsuario() {
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

    public List<Usuario> getUsuariosPorRol(Rol rol) {
        return new ArrayList<>(usuarios.getOrDefault(rol, new ArrayList<>()));
    }

    public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    private boolean nombreUsuarioExiste(String nombreUsuario) {
        return usuarios.values().stream()
                       .flatMap(ArrayList::stream)
                       .anyMatch(u -> u.getNombreUsuario().equals(nombreUsuario));
    }

    private String obtenerDatoEspecifico(String dato) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese " + dato + ": ");
        return scanner.nextLine();
    }

    private double obtenerSalario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Salario: ");
        return scanner.nextDouble();
    }

    private LocalDate obtenerFecha() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Fecha de nacimiento (yyyy-MM-dd): ");
        String fecha = scanner.nextLine();
        return LocalDate.parse(fecha);
    }
}
