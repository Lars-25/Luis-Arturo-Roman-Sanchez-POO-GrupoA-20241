package Sistema;

import java.util.Scanner;
import Usuarios.*;

public class Menu {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner sc = new Scanner(System.in);

    public static void ejecutarMenu() {
        while (true) {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("1. Iniciar sesion");
            System.out.println("2. Registrar nuevo usuario");
            System.out.println("3. Salir");
            System.out.print("Elija una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    iniciarSesion();
                    break;
                case "2":
                    registrarNuevoUsuario();
                    break;
                case "3":
                    System.out.println("Gracias por utilizar el sistema.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }
    }

    private static void iniciarSesion() {
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = sc.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = sc.nextLine();

        Usuario usuario = biblioteca.verificarInicioSesion(nombreUsuario, contrasena);
        if (usuario != null) {
            System.out.println("Inicio de sesión exitoso.");
            mostrarMenuUsuario(usuario);
        } else {
            System.out.println("Datos de inicio de sesión incorrectos.");
        }
    }

    private static void registrarNuevoUsuario() {
        System.out.println("Seleccione el tipo de usuario a registrar:");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        System.out.print("Elija una opción: ");
        String tipo = sc.nextLine();
        System.out.print("Ingrese nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Ingrese nombre de usuario: ");
        String nombreUsuario = sc.nextLine();
        System.out.print("Ingrese contraseña: ");
        String contrasena = sc.nextLine();

        boolean resultado = false;
        switch (tipo) {
            case "1":
                resultado = biblioteca.registrarCliente(nombre, apellido, nombreUsuario, contrasena);
                break;
            case "2":
                System.out.print("Ingrese salario: ");
                double salario = Double.parseDouble(sc.nextLine());
                resultado = biblioteca.registrarTrabajador(nombre, apellido, nombreUsuario, contrasena, salario);
                break;
            case "3":
                System.out.print("Ingrese salario: ");
                salario = Double.parseDouble(sc.nextLine());
                resultado = biblioteca.registrarGerente(nombre, apellido, nombreUsuario, contrasena, salario);
                break;
        }
        if (resultado) {
            System.out.println("Usuario registrado exitosamente.");
        } else {
            System.out.println("Error al registrar usuario, posiblemente el nombre de usuario ya existe.");
        }
    }

    private static void mostrarMenuUsuario(Usuario usuario) {
        System.out.println("Bienvenido, " + usuario.getNombre());
        if (usuario instanceof Gerente) {
            ejecutarMenuGerente();
        } else if (usuario instanceof Trabajador) {
            ejecutarMenuTrabajador();
        } else if (usuario instanceof Cliente) {
            ejecutarMenuCliente();
        } else {
            System.out.println("Tipo de usuario no reconocido.");
        }
    }

    private static void ejecutarMenuGerente() {
        String option = "";
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar libro");
            System.out.println("5 - Actualizar la informacion del libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("7 - Mostrar rentas");
            System.out.println("8. Rentar un libro.");
            System.out.println("9 - Salir de este menu.");
            option=leer.nextLine();
            switch (option){
                case "1" :
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "4" :
                    break;
                case "5" :
                    break;
                case "6" :
                    break;
                case "8":
                    break;
                case "9" :
                    break;
                default :
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }while(!option.equals("9"));
    }

    private static void ejecutarMenuTrabajador() {
        String option = "" ;
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar libro");
            System.out.println("5 - Actualizar la informacion del libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("7 - Salir de este menu.");
            option=leer.nextLine();
            switch (option){
                case "1" :
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "4" :
                    break;
                case "5" :
                    break;
                case "6" :
                    break;
                case "7" :
                    break;
                default :
                    System.out.println("Opción no válida, intente de nuevo.");
                break;
            }
        }while(!option.equals("7"));
    }

    private static void ejecutarMenuCliente() {
        String option = "";
        Scanner leer = new Scanner(System.in);
        do{
            System.out.println("1 - Ver rentas");
            System.out.println("2 - Ver tu informacion");
            System.out.println("3 - Ver libros disponibles");
            System.out.println("4 - Salir de este menu.");
            option=leer.nextLine();
            switch (option){
                case "1" :
                    break;
                case "2" :
                    break;
                case "3" :
                    break;
                case "4" :
                    break;
                default :
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(!option.equals("4"));
    }

}


