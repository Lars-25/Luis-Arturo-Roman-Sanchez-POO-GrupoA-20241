package Serializers;

import Libreria.Libreria;
import Models.LibrosModel;
import Usuarios.Gerente;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import Libreria.Libros.Libro;
import Libreria.Libros.Constantes.Genero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LibroDeserializer {

    public static void LibroDeserealizer(){
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("libros.json"));
            LibrosModel librosModel = gson.fromJson(reader, LibrosModel.class);
            reader.close();

            ArrayList<Libro> librosComedia = new ArrayList<>(librosModel.getComedia());

            ArrayList<Libro> librosTerror = new ArrayList<>(librosModel.getTerror());

            ArrayList<Libro> librosAccion = new ArrayList<>(librosModel.getAccion());

            Libreria.libros.put(Genero.Comedia, librosComedia);
            Libreria.libros.put(Genero.Accion, librosAccion);
            Libreria.libros.put(Genero.Terror, librosTerror);

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (JsonSyntaxException e) {
            System.out.println("Error de sintaxis JSON: " + e.getMessage());
        } catch (JsonParseException e) {
            System.out.println("Error al parsear JSON: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
