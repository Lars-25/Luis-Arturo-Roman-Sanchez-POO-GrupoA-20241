package sistema;

import usuarios.*;
import usuarios.utils.Rol;
import usuarios.utils.UsuarioEnSesion;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {

    private static final Scanner scanner = new Scanner(System.in);
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();
    private static UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    private static Usuario usuarioActual = null;

    public Biblioteca() {
        for (Rol rol : Rol.values()) {
            usuarios.put(rol, new ArrayList<>());
        }
    }

    private static Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                    usuarioEnSesion = UsuarioEnSesion.getInstancia();
                    usuarioEnSesion.setUsuario(usuario);
                }
            }
        }
        return null;
    }

    public static Usuario iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = verificarInicioSesion(nombreUsuario, contrasena);
        if (usuario != null) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre());
            Menu.menuUsuarios();
            return usuario;
        } else {
            System.out.println("Credenciales incorrectas, por favor intente nuevamente.");
            return null;
        }
    }

    public static void registrarse() {
        System.out.println("Seleccione el tipo de usuario para registro:");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1:
                Cliente.registrarCliente();
                break;
            case 2:
                Trabajador.registrarTrabajador();
                break;
            case 3:
                Gerente.registrarGerente();
                break;
            default:
                System.out.println("Opción no válida, por favor intente nuevamente.");
        }
    }

    public static void agregarUsuario(Rol rol, Usuario usuario) {
        if (!usuarios.containsKey(rol)) {
            usuarios.put(rol, new ArrayList<>());
        }
        usuarios.get(rol).add(usuario);
    }

    public static void eliminarUsuario(Rol rol, String nombreUsuario) {
        ArrayList<Usuario> listaUsuarios = usuarios.get(rol);
        if (listaUsuarios != null) {
            listaUsuarios.removeIf(usuario -> usuario.getNombreUsuario().equals(nombreUsuario));
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("No se encontraron usuarios bajo este rol.");
        }
    }

    public static HashMap<Rol, ArrayList<Usuario>> getUsuarios() {
        return usuarios;
    }

    public static void mostrarInformacionUsuario(Usuario usuario) {
        System.out.printf("ID: %d, Nombre: %s, Apellido: %s, Usuario: %s, Rol: %s, Teléfono: %s\n",
                          usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getNombreUsuario(), usuario.getRol(), usuario.getNumeroTelefono());
    }

}