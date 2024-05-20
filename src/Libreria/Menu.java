package Libreria;

import Usuarios.Usuario;
import Usuarios.utils.Rol;
import Utils.UsuarioEnSesion;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {

    public static Scanner leer = new Scanner(System.in);
    private static Libreria libreria;

    public Menu(Libreria libreria) {
        Menu.libreria = libreria;
    }

    public static void mostrarMenu() {
        while (true) {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA.");
            System.out.println("1. Registrar");
            System.out.println("2. Iniciar Sesion");
            System.out.println("E. Salir");
            System.out.println("Elige una opción: ");

            String opcion = leer.nextLine();

            switch (opcion) {
                case "1":
                    registrar();
                    break;
                case "2":
                    iniciarSesion();
                    break;
                case "E":
                    libreria.guardarJson();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        }
    }

    public static void registrar() {
        System.out.println("Seleccione el tipo de usuario a registrar: ");
        System.out.println("1. Cliente");
        System.out.println("2. Trabajador");
        System.out.println("3. Gerente");
        String opcion = leer.nextLine();

        switch (opcion) {
            case "1":
                libreria.agregarCliente();
                break;
            case "2":
                libreria.agregarTrabajador();
                break;
            case "3":
                libreria.agregarGerente();
                break;
            default:
                System.out.println("Opción incorrecta");
                break;
        }
    }

    private static String obtenerNombreUsuario() {
        boolean nombreUsuarioExistente;
        String nombreUsuario;
        do {
            System.out.println("Ingrese el nombre de usuario: ");
            nombreUsuario = leer.nextLine();
            nombreUsuarioExistente = libreria.nombreUsuarioExistente(nombreUsuario);
            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Inténtalo de nuevo.");
            }
        } while (nombreUsuarioExistente);
        return nombreUsuario;
    }

    private static String obtenerNumeroTelefono() {
        boolean numeroExistente;
        String telefono;
        do {
            System.out.println("Ingrese el número de teléfono: ");
            telefono = leer.nextLine();
            numeroExistente = libreria.numeroTelefonoExistente(telefono);
            if (numeroExistente) {
                System.out.println("El número de teléfono ya existe. Inténtalo de nuevo.");
            }
        } while (numeroExistente);
        return telefono;
    }


    public static void iniciarSesion() {

        boolean datoscorrectos = false;
        int cont = 0;

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA.");
            System.out.println("Inicia sesion para continuar, tienes 5 intentos: ");

            System.out.println("Ingresa tu nombre de usuario: ");
            String user = leer.nextLine();

            System.out.println("Ingresa tu contraseña: ");
            String contra = leer.nextLine();
            cont++;

            Usuario actual = libreria.verificarInicioSesion(user, contra);

            if (actual != null && cont < 5) {
                UsuarioEnSesion.getInstancia().setUsuario(actual);
                seleccionarMenu();
                cont = 0;
            } else if (cont >= 5) {
                System.out.println("INTENTOS TERMINADOS, TERMINANDO EL PROGRAMA. ");
                datoscorrectos = true;
                libreria.guardarJson();
                System.exit(0);
            } else {
                System.out.println("DATOS INCCORRECTOS. ");
            }

        } while (!datoscorrectos);

    }

    private static void registrarLibroMenu(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean esDatoValido = false, accion=true;

        do {
            System.out.println("OPCION DE REGISTRAR UN LIBRO. ");
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Terror.");
            System.out.println("2. Comedia.");
            System.out.println("3. Acccion. ");
            System.out.println("4. Regresar al menu principal. ");
            while (!esDatoValido) {
                try {
                    opcion = leer.nextInt();
                    if (opcion < 1 || opcion > 4) {
                        throw new InputMismatchException(); //agrega un error de manera "forzosa"
                    }
                    esDatoValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Opcion no valida, ingresa otra porfavor..");
                } finally { //el finally siempre va a fincionar, sin importar si entra a los errores o no
                    sc.nextLine();
                }
            }
            esDatoValido = false;
            switch (opcion) {
                case 1:
                    System.out.println("REGISTRAR LIBRO DE TERROR. ");
                    libreria.registrarTerror();
                    break;
                case 2:
                    System.out.println("REGISTRAR LIBRO DE COMEDIA. ");
                    libreria.registrarComedia();
                    break;
                case 3:
                    System.out.println("REGISTRAR LIBRO ACCION. ");
                    libreria.registrarAccion();
                    break;
                case 4:
                    accion=false;
                    break;
            }


        }while (accion);
    }


    private static void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case Gerente -> ejecutarMenuGerente();
            case Trabajador -> ejecutarMenuTrabajador();
            case Clientes -> ejecutarMenuCliente();
        }
    }


    private static void ejecutarMenuCliente() {
        String option;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("1 - Ver rentas");
            System.out.println("2 - Ver tu informacion");
            System.out.println("3 - Ver libros disponibles");
            System.out.println("E - Salir de este menu.");
            option = leer.nextLine();
            switch (option) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "E":
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    libreria.librosAGson();
                    libreria.usuariosAGson();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (!option.equals("E"));
    }

    private static void ejecutarMenuTrabajador() {
        String option;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar libro");
            System.out.println("5 - Actualizar la informacion del libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("E - Salir de este menu.");
            option = leer.nextLine();
            switch (option) {
                case "1":
                    libreria.agregarCliente();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    registrarLibroMenu();
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "7":
                    break;
                case "E":
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (!option.equals("E"));
    }

    private static void ejecutarMenuGerente() {
        String option;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("\n 1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar trabajador");
            System.out.println("5 - Actualizar la informacion de un trabajador");
            System.out.println("6 - Eliminar trabajador");
            System.out.println("7 - Mostrar rentas");
            System.out.println("8. Agregar un libro.");
            System.out.println("9. Mostrar todos los usuarios. ");
            System.out.println("10. Mostrar todos los clientes. ");
            System.out.println("11. Mostrar todos los trabajadores. ");
            System.out.println("12. Mostrar la informacion de un usuario en especifico. ");
            System.out.println("13. Eliminar a un usuario. ");
            System.out.println("14. Actualizar la informacion de un usuario. ");
            System.out.println("E - Salir de este menu.");
            option = leer.nextLine();
            switch (option) {
                case "1":
                    libreria.agregarCliente();
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    libreria.agregarTrabajador();
                    break;
                case "5":
                    break;
                case "6":
                    break;
                case "8":
                    registrarLibroMenu();
                    break;
                case "9":
                    System.out.println("Has seleccionado la opcion de mostrar a todos los usuarios: ");
                    libreria.mostrarUsuarios();
                    break;
                case "10":
                    System.out.println("Has seleccionado la opcion de mostrar a todos los clientes. ");
                    libreria.mostrarClientes();
                    break;
                case "11":
                    System.out.println("Has seleccionado la opcion de mostrar a todos los trabajadores: ");
                    libreria.mostrarTrabajadores();
                    break;
                case "12":
                    libreria.mostrarNombreUsuario();
                    System.out.println("Escribe el nombre del usuario del cual quieres conocer su informacion: ");
                    String username= leer.nextLine();
                    Usuario user =libreria.getUsuarioPorNombreUsuario(username);
                    if (user!=null){
                        libreria.mostrarUsuario(user);
                    } else{
                        System.out.println("EL USUARIO NO EXISTE. ");
                    }
                    break;
                case "13":
                    libreria.mostrarNombreUsuario();
                    System.out.println("Escribe el nombre del usuario al cual quieres eliminar: ");
                    username= leer.nextLine();
                    Usuario user1 =libreria.getUsuarioPorNombreUsuario(username);
                    if (user1!=null){
                        libreria.eliminarUsuario(user1);
                    } else{
                        System.out.println("EL USUARIO NO EXISTE. ");
                    }

                    break;
                case "14":
                    libreria.mostrarNombreUsuario();
                    System.out.println("Escribe el nombre del usuario al cual quieres cambiar su informacion: ");
                    username= leer.nextLine();
                    Usuario user2 =libreria.getUsuarioPorNombreUsuario(username);
                    if (user2!=null){
                        libreria.actualizarInfo(user2);
                    } else{
                        System.out.println("EL USUARIO NO EXISTE. ");
                    }
                    break;
                case "E":
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    iniciarSesion();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
        } while (true);
    }

}