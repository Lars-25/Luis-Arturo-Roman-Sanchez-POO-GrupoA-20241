package Libreria.utils;

import Libreria.Libreria;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.*;

public class DatosComun {

    public static ArrayList<String> obtenerDatosComun (Rol rol){
        ArrayList<String> datosComun = new ArrayList<>();
        Scanner leer= new Scanner(System.in);
        //OPERADOR TERNARIO
        // EL ? significa un if a todo lo que pongas antes de eso, los : funcionan como un else para todo lo que venga despues
        String rolActual = rol == Rol.Clientes ? "Cliente": rol == Rol.Trabajador ? "Trabajador" : "Gerente";

        System.out.println("Ingresa el nombre");
        String nombre = leer.nextLine();
        System.out.println("Ingresa el apellido");
        String apellido = leer.nextLine();
        String numero = obtenerNumeroTelefono();
        String nombreUsuario = obtenerNombreUsuario();


        System.out.println("Ingresa la contraseña: ");
        String contraseña = leer.nextLine();



        datosComun.addAll(Arrays.asList(nombre,apellido,numero,nombreUsuario,contraseña));
        return datosComun;
    }

    public static LocalDate obtenerFechaNacimiento(){
        int dia, mes, ano;
        LocalDate fechaNacimiento;
        Scanner read = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingresa la fecha de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1 && numero <= 31) {
                    dia = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 01 y 31.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        while (true) {
            try {
                System.out.println("Ingresa el mes de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1 && numero <= 12) {
                    mes = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 01 y 12.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        while (true) {
            try {
                System.out.println("Ingresa el año de nacimiento: ");
                int numero = read.nextInt();

                if (numero >= 1920 && numero <= 2006) {
                    ano = numero;
                    break;
                } else {
                    System.out.println("Número inválido. Debe ser un entero entre 1920 y 2006. ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                read.nextLine(); // Limpiar el buffer del scanner para evitar un bucle infinito
            }
        }
        return fechaNacimiento = LocalDate.of(ano, mes, dia);
    }


    private static String obtenerNumeroTelefono() {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente;
        String telefono;
        Collection<ArrayList<Usuario>> usuariosCollection = Libreria.usuarios.values(); //obtenemos la coleccion de todos llos dato
        do {
            System.out.println("Ingresa el número de teléfono");
            telefono = scanner.nextLine();
            numeroExistente = false;
            for (ArrayList<Usuario> usuariosLista : usuariosCollection) {
                for (Usuario usuario : usuariosLista) {
                    if (usuario.getNumeroTelefono().equals(telefono)) {
                        numeroExistente = true;
                        break;
                    }
                }
            }
            if (numeroExistente) {
                System.out.println("El número ya existe. Inténtalo de nuevo\n");
            }
        } while (numeroExistente);
        return telefono;
    }

    private static String obtenerNombreUsuario() {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente;
        String nombreUsuario;
        Collection<ArrayList<Usuario>> usuariosCollection = Libreria.usuarios.values(); //obtenemos la coleccion de todos llos dato
        do {
            System.out.println("Ingresa el nombre de usuario");
            nombreUsuario = scanner.nextLine();
            nombreUsuarioExistente = false;
            for (ArrayList<Usuario> usuariosLista : usuariosCollection) {
                for (Usuario usuario : usuariosLista) {
                    if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                        nombreUsuarioExistente = true;
                        break;
                    }
                }
            }
            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Inténtalo de nuevo\n");
            }
        } while (nombreUsuarioExistente);
        return nombreUsuario;
    }
}
