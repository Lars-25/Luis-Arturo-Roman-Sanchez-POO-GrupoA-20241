package Libreria.Libros;

import Libreria.Libreria;
import Libreria.Libros.Constantes.Genero;
import Libreria.Libros.utilsLibros.LibrosUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class LibroComedia extends Libro{

    public LibroComedia(String titulo, String autor, String editorial, LocalDate fecha, double precio, int stock) {
        super(titulo, autor, editorial, fecha, Genero.Comedia, precio, stock);
    }

    public static void registrarLibroComedia(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> datosComun = LibrosUtils.getLibrosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        LibroComedia librocomedia = new LibroComedia(nombre, autor, editorial, fechaPublicacion, precio, stock);

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
}
