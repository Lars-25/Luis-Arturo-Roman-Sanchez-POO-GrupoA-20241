package Libreria.Libros;

import Libreria.Libreria;
import Libreria.Libros.Constantes.Genero;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Libro {
    public static int CANTIDAD_LIBROS = 1;
    private int id;
    private String titulo;
    private String autor;
    private String editorial;
    private LocalDate fecha;
    private Genero genero;
    private double precio;
    private int stock;

    public Libro (String titulo, String autor, String editorial, LocalDate fecha, Genero genero, double precio, int stock) {
        this.id = CANTIDAD_LIBROS;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.fecha = fecha;
        this.genero = genero;
        this.precio = precio;
        this.stock = stock;
        CANTIDAD_LIBROS ++;
    }

    //filtrado por precio (ingresa un precio y muestra los mayores de ese precio)
    //genero (muestra los de un genero en especcifico)
    //primera letra del autor (usuario ingresa la primera letra, y muestre los que cumplan)
    //por stock (ingresado el stock, que sea mayor)

    protected abstract void filtradoPrecio(double precio);

    protected abstract void filtradoAlfabetico(String c);

    protected abstract void filtradoAutor(String autor);

    public double getPrecio(){return precio;}


    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Genero getGenero() {
        return genero;
    }

    public int getStock() {
        return stock;
    }

    public static Libro seleccionarLibro (){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean esDatoValido = false, estaSeleccionado = false;

        do {
            System.out.println("OPCION DE SELECCIONAR UN LIBRO. ");
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Terror.");
            System.out.println("2. Comedia.");
            System.out.println("3. Acccion. ");
            while (!esDatoValido) {
                try {
                    opcion = sc.nextInt();
                    if (opcion < 1 || opcion > 4) {
                        throw new InputMismatchException();
                    }
                    esDatoValido = true;
                } catch (InputMismatchException e) {
                    System.out.println("Opcion no valida, ingresa otra porfavor..");
                } finally {
                    sc.nextLine();
                }
            }
            esDatoValido = false;
            switch (opcion) {
                case 1:
                    Libro book;
                    while (true) {
                        book = mostrarLibro(Genero.Terror);
                        if (book == null) {
                            System.out.println("Intenta de nuevo. ");
                        } else {
                            break;
                        }
                    }
                    return book;
                case 2:
                    while (true) {
                        book = mostrarLibro(Genero.Comedia);
                        if (book == null) {
                            System.out.println("Intenta de nuevo. ");
                        } else {
                            break;
                        }
                    }
                    return book;
                case 3:
                    while (true) {
                        book = mostrarLibro(Genero.Accion);
                        if (book == null) {
                            System.out.println("Intenta de nuevo. ");
                        } else {
                            break;
                        }
                    }
                    return book;
            }


        }while (true);
    }

    public static Libro mostrarLibro(Genero genero){
        Scanner sc = new Scanner(System.in);
        Libro book = null;
        ArrayList<Libro> accion = Libreria.libros.get(Genero.Accion);
        for (Libro libro : accion) {
            System.out.println(libro.getTitulo());
        }
        System.out.println("Ingresa el titulo del libro: ");
        String titulo = sc.nextLine();
        for (Libro libro : accion) {
            if (titulo.equals(libro.getTitulo())) {
                book = libro;
                break;
            }
            else {
                System.out.println("Titulo no existente. ");
                break;
            }
        }
        return book;
    }

    public static void mostrarTodosLibros(){
        System.out.println("Mostrando a todos los libros. ");
        System.out.println("LIBROS DE TERROR: ");
        for ( Libro libro : Libreria.libros.get(Genero.Terror)){
            LibroTerror libroTerror = (LibroTerror) libro;
            System.out.println("Titulo" + libro.getTitulo());
            System.out.println("Autor" + libro.getAutor());
            System.out.println("Editorial" + libro.getEditorial());
            System.out.println("Fecha" + libro.getFecha());
            System.out.println("Precio:" + libro.getPrecio());
            System.out.println("Stock" + libro.getStock());
            System.out.println("Subgenero:" + libroTerror.getSubGeneroTerror());
        }
        System.out.println("LIBROS DE COMEDIA: ");
        for ( Libro libro : Libreria.libros.get(Genero.Comedia)){
            System.out.println("Titulo" + libro.getTitulo());
            System.out.println("Autor" + libro.getAutor());
            System.out.println("Editorial" + libro.getEditorial());
            System.out.println("Fecha" + libro.getFecha());
            System.out.println("Precio:" + libro.getPrecio());
            System.out.println("Stock" + libro.getStock());
        }
        System.out.println("LIBROS DE ACCION: ");
        for ( Libro libro : Libreria.libros.get(Genero.Accion)){
            System.out.println("Titulo" + libro.getTitulo());
            System.out.println("Autor" + libro.getAutor());
            System.out.println("Editorial" + libro.getEditorial());
            System.out.println("Fecha" + libro.getFecha());
            System.out.println("Precio:" + libro.getPrecio());
            System.out.println("Stock" + libro.getStock());
        }
    }


}
