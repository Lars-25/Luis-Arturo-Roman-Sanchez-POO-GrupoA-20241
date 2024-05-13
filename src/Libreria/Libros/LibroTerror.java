package Libreria.Libros;

import Libreria.Libreria;
import Libreria.Libros.Constantes.Genero;
import Libreria.Libros.Constantes.SubGeneroTerror;
import Libreria.Libros.utilsLibros.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LibroTerror extends Libro {

    private SubGeneroTerror subGeneroTerror;
    public LibroTerror(String titulo, String autor, String editorial, LocalDate fecha, double precio, int stock, SubGeneroTerror subGeneroTerror) {
        super(titulo, autor, editorial, fecha,Genero.Terror, precio, stock);
        this.subGeneroTerror = subGeneroTerror;
    }

    public static void registrarLibroTerror() {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = LibrosUtils.getLibrosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("Selecciona una opción");
        System.out.println("1. Psicológico");
        System.out.println("2. Crímen");

        int opcionSubgenero;
        SubGeneroTerror subgeneroInput = null;
        while (true) {
            try {
                System.out.println("Ingresa la opcion: ");
                opcionSubgenero = scanner.nextInt();

                if (opcionSubgenero == 1  || opcionSubgenero == 2) {
                    break;
                } else {
                    System.out.println("Opcion no existente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número entero.");
                scanner.nextLine();
            }
        }

        if (opcionSubgenero == 1) {
            subgeneroInput = SubGeneroTerror.Psicologico;
        } else {
            subgeneroInput = SubGeneroTerror.Crimen;
        }

        LibroTerror libroTerror = new LibroTerror(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);

    }


    public static void eliminarLibro(){
        Libro libro = seleccionarLibro();
        Libreria.libros.values().remove(libro);
    }

    @Override
    public void filtradoPrecio(double precio) {
        Libreria.libros.get(Genero.Terror).stream()//un stream es una coleccion de datos que nos permite hacer operaciones secuenciales
                .filter(libro -> libro.getPrecio()<precio)// hace un filtro comparando con el precio que le estoy mandando,el filter recibe de parametro una funcion, se le pone de parametro una funcion lambda
                .forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+ " Precio:"+libro.getPrecio()));//aqui lo regresa de nuevo a ser lista, ya que antes de esta linea es un objeto de tipo stream

    }

    @Override
    protected void filtradoAlfabetico(String c) {
        Libreria.libros.get(Genero.Terror).stream()
                .filter(libro -> libro.getTitulo().contains(c))
                .forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+ " Precio:"+libro.getPrecio()));
    }

    @Override
    protected void filtradoAutor(String autor) {
            Libreria.libros.get(Genero.Terror).stream()
                    .filter(libro -> libro.getAutor().equals(autor))
                    .forEach(libro -> System.out.println("Titulo: "+libro.getTitulo()+ " Precio:"+libro.getPrecio()));

    }

    public SubGeneroTerror getSubGeneroTerror() {
        return subGeneroTerror;
    }
}
