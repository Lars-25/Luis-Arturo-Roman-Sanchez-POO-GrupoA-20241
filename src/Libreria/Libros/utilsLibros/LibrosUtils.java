package Libreria.Libros.utilsLibros;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LibrosUtils {

    public static ArrayList<String> getLibrosComun(){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> librosComun = new ArrayList<>();
        String nombreLibro="", autorLibro ="", editorialLibro="";
        double precioLibro=0; int stockLibro=0;


        do {
            System.out.println("Ingresa el nombre del libro: ");
            nombreLibro = sc.nextLine();
            if (nombreLibro.isEmpty()) {
                System.out.println("Nombre vacio no es valido. ");
            } else{
                break;
            }
        } while (true);


        do {
            boolean band = false;
            System.out.println("Ingresa el autor del libro: ");
            autorLibro = sc.nextLine();
            if (autorLibro.isEmpty()) {
                band = true;
            } else{
                for (int i = 0; i < autorLibro.length(); i++) {
                    if (autorLibro.charAt(i) == '1' || autorLibro.charAt(i) == '2' || autorLibro.charAt(i) == '3' || autorLibro.charAt(i) == '4' || autorLibro.charAt(i) == '5' || autorLibro.charAt(i) == '6' || autorLibro.charAt(i) == '7' || autorLibro.charAt(i) == '8' || autorLibro.charAt(i) == '9' || autorLibro.charAt(i) == '0'){
                        band = true;
                        break;
                    }
                }
            }
            if (band){
                System.out.println("Apellido materno con números/vacío no es válido, por favor ingresa otro. ");
            } else {
                break;
            }
        } while (true);


        do {
            System.out.println("Ingresa la editorial del libro: ");
            editorialLibro = sc.nextLine();
            if (editorialLibro.isEmpty()) {
                System.out.println("Editorial vacia no es valido. ");
            } else{
                break;
            }
        } while (true);

        LocalDate fecha = obtenerFechaCreacion();


       do {
           try {
               System.out.println("Ingresa el precio del libro: ");
               precioLibro = sc.nextDouble();
               break;
           } catch (InputMismatchException e) {
               System.out.println("Ingresa un numero valido. ");
               sc.nextLine();
           }
       } while (true);

        do {
            try {
                System.out.println("Ingresa el stock del libro: ");
                stockLibro = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Ingresa un numero valido. ");
                sc.nextLine();
            }
        } while (true);


        librosComun.addAll(Arrays.asList(nombreLibro,autorLibro,editorialLibro, fecha.toString(),String.valueOf(precioLibro),String.valueOf(stockLibro)));
        return librosComun;
    }

    public static LocalDate obtenerFechaCreacion(){
        int dia, mes, ano;
        LocalDate fechaNacimiento;
        Scanner read = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Ingresa el dia de creacion: ");
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
                System.out.println("Ingresa el mes de creacion: ");
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
                System.out.println("Ingresa el año de creacion: ");
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
}
