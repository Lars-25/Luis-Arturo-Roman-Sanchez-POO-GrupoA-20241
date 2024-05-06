package sistema;

import usuarios.*;
import usuarios.utils.Rol;
import usuarios.utils.UsuarioEnSesion;

import java.util.Scanner;
import sistema.utils.DatosComun;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Biblioteca biblioteca = new Biblioteca();
    private static UsuarioEnSesion usuarioEnSesion = UsuarioEnSesion.getInstancia();
    private static Usuario usuarioActual = null;

    public static void ejecutarMenu() {
        int opcion = 1;
        while (opcion>0 && opcion<3) {
            System.out.println("\nBienvenido al Sistema de la Biblioteca");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Biblioteca.iniciarSesion();
                    break;
                case 2:
                    Biblioteca.registrarse();
                    break;
                case 3:
                    System.out.println("Gracias por usar el sistema.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        }
    }

    public static void menuUsuarios(){
        if(usuarioEnSesion.getUsuarioActual() instanceof Cliente){
            ejecutarMenuCliente();
        }else if(usuarioEnSesion.getUsuarioActual() instanceof Trabajador){
            ejecutarMenuTrabajador();
        }else{
            ejecutarMenuGerente();
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
                    Biblioteca.mostrarInformacionUsuario(usuarioActual);
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
                    Cliente.registrarCliente();
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
                    return;
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
                    Gerente.mostrarTodosLosUsuarios();
                    break;
                case "2":
                    break;
                case "3":
                    Trabajador.registrarTrabajador(); 
                    break;
                case "4":
                    // Implementar: modificarDatosTrabajador();
                    break;
                case "5":
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Ingrese el nombre de usuario del trabajador a eliminar:");
                    String nombreUsuario = scanner.nextLine();
                    Trabajador.eliminarTrabajador(nombreUsuario);
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

    
}
