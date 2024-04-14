package Sistema;

import java.util.Scanner;
import Usuarios.*;

public class Menu {

    public static void ejecutarMenu(){

    }
    public static void ejecutarMenuCliente(){
        String option = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1 - Ver rentas");
            System.out.println("2 - Ver tu informacion");
            System.out.println("3 - Ver libros disponibles");
            System.out.println("4 - Salir");
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
        }while(option != "4");
    }
    public static void ejecutarMenuTrabajador(){
        String option = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar libro");
            System.out.println("5 - Actualizar la informacion del libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("7 - Salir");
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
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(option != "7");
    }
    public static void ejecutarMenuGerente(){
        String option = null;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1 - Registrar cliente");
            System.out.println("2 - Actualizar la informacion del cliente");
            System.out.println("3 - Eliminar cliente");
            System.out.println("4 - Registrar libro");
            System.out.println("5 - Actualizar la informacion del libro");
            System.out.println("6 - Eliminar libro");
            System.out.println("7 - Mostrar rentas");
            System.out.println("8 Rentar un libro.");
            System.out.println("9 - Salir");
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
                    System.out.println("Opcion incorrecta");
                    break;
            }
        }while(option != "9");
    }
}