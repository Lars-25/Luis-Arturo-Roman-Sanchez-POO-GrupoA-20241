package Models;

import Libreria.Libros.Libro;
import Libreria.Libros.LibroComedia;
import Libreria.Libros.LibroTerror;
import Libreria.Libros.LibroAccion;

import java.util.ArrayList;

public class LibrosModel {
    ArrayList<LibroComedia> comedia = new ArrayList<>();
    ArrayList<LibroTerror> terror = new ArrayList<>();
    ArrayList<LibroAccion> accion = new ArrayList<>();

    public ArrayList<LibroComedia> getComedia() {
        return comedia;
    }

    public ArrayList<LibroTerror> getTerror(){
        return terror;
    }

    public ArrayList<LibroAccion> getAccion(){
        return accion;
    }

}
