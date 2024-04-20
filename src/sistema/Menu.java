package sistema;

import usuarios.*;
import usuarios.utils.Rol;
import java.util.Scanner;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();
    private static Usuario usuarioActual = null;

    public static void ejecutarMenu() {
        while (true) {
            System.out.println("\nBienvenido al Sistema de la Biblioteca");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarse();
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = biblioteca.verificarInicioSesion(nombreUsuario, contrasena);
        if (usuario != null) {
            usuarioActual = usuario;
            System.out.println("Inicio de sesión exitoso. Bienvenido " + usuario.getNombre());
            if (usuario instanceof Cliente) {
                ejecutarMenuCliente();
            } else if (usuario instanceof Trabajador) {
                ejecutarMenuTrabajador();
            } else if (usuario instanceof Gerente) {
                ejecutarMenuGerente();
            }
        } else {
            System.out.println("Credenciales incorrectas, por favor intente nuevamente.");
        }
    }

    private static void registrarse() {
        System.out.println("Seleccione el tipo de usuario para registro:");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.print("Opción: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        switch (tipo) {
            case 1:
                biblioteca.registrarCliente();
                break;
            case 2:
                biblioteca.registrarTrabajador();
                break;
            case 3:
                biblioteca.registrarGerente();
                break;
            default:
                System.out.println("Opción no válida, por favor intente nuevamente.");
        }
    }

    private static void ejecutarMenuCliente() {
        String option;
        do {
            System.out.println("\n1 - Ver información personal");
            System.out.println("2 - Ver préstamos activos");
            System.out.println("3 - Ver libros disponibles");
            System.out.println("E - Cerrar sesión y salir al menú principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    mostrarInformacionUsuario(usuarioActual);
                    break;
                case "2":
                    // Implementar: mostrarPréstamosActivos(usuarioActual);
                    break;
                case "3":
                    // Implementar: mostrarLibrosDisponibles();
                    break;
                case "E":
                    System.out.println("Cerrando sesión...");
                    usuarioActual = null;
                    return;  // Salir del método
                default:
                    System.out.println("Opción incorrecta, intente nuevamente.");
            }
        } while (!option.equalsIgnoreCase("E"));
    }

    private static void ejecutarMenuTrabajador() {
        String option;
        do {
            System.out.println("\n1 - Registrar nuevo cliente");
            System.out.println("2 - Modificar datos de cliente");
            System.out.println("3 - Registrar nuevo libro");
            System.out.println("4 - Modificar datos de libro");
            System.out.println("E - Cerrar sesión y salir al menú principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    biblioteca.registrarCliente();
                    break;
                case "2":
                    // Implementar: modificarDatosCliente();
                    break;
                case "3":
                    // Implementar: registrarNuevoLibro();
                    break;
                case "4":
                    // Implementar: modificarDatosLibro();
                    break;
                case "E":
                    System.out.println("Cerrando sesión...");
                    usuarioActual = null;
                    return;  // Salir del método
                default:
                    System.out.println("Opción incorrecta, intente nuevamente.");
            }
        } while (!option.equalsIgnoreCase("E"));
    }

    private static void ejecutarMenuGerente() {
        String option;
        do {
            System.out.println("\n1 - Ver todos los usuarios");
            System.out.println("2 - Ver detalles de un usuario específico");
            System.out.println("3 - Registrar nuevo trabajador");
            System.out.println("4 - Modificar datos de trabajador");
            System.out.println("5 - Eliminar trabajador");
            System.out.println("E - Cerrar sesión y salir al menú principal");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    mostrarTodosLosUsuarios();
                    break;
                case "2":
                    System.out.print("Ingrese el nombre de usuario del empleado: ");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = biblioteca.getUsuarioPorNombreUsuario(nombreUsuario);
                    if (usuario != null) {
                        mostrarInformacionUsuario(usuario);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case "3":
                    biblioteca.registrarTrabajador(); 
                    break;
                case "4":
                    // Implementar: modificarDatosTrabajador();
                    break;
                case "5":
                    // Implementar: eliminarTrabajador();
                    break;
                case "E":
                    System.out.println("Cerrando sesión...");
                    usuarioActual = null;
                    return;
                default:
                    System.out.println("Opción incorrecta, intente nuevamente.");
            }
        } while (!option.equalsIgnoreCase("E"));
    }

    private static void mostrarTodosLosUsuarios() {
        System.out.println("Listado de todos los usuarios:");
        for (Rol rol : Rol.values()) {
            System.out.println("Rol: " + rol);
            for (Usuario u : biblioteca.getUsuariosPorRol(rol)) {
                mostrarInformacionUsuario(u);
            }
        }
    }

    private static void mostrarInformacionUsuario(Usuario usuario) {
        System.out.printf("ID: %d, Nombre: %s, Apellido: %s, Usuario: %s, Rol: %s%n",
                          usuario.getId(), usuario.getNombre(), usuario.getApellido(), usuario.getNombreUsuario(), usuario.getRol());
    }
}
