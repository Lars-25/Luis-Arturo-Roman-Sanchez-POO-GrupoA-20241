package Serializers;

import Libreria.Libreria;
import Models.UsuarioModel;
import Usuarios.Gerente;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioDeserializer {

    public static void UsuarioDeserializer() {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            UsuarioModel usuariosModel = gson.fromJson(reader, UsuarioModel.class);
            reader.close();

            ArrayList<Usuario> usuariosGerentes = new ArrayList<>(usuariosModel.getGerentes());
            ArrayList<Usuario> usuariosTrabajadores = new ArrayList<>(usuariosModel.getTrabajadores());
            ArrayList<Usuario> usuariosClientes = new ArrayList<>(usuariosModel.getClientes());

            Libreria.usuarios.put(Rol.Gerente, usuariosGerentes);
            Libreria.usuarios.put(Rol.Trabajador, usuariosTrabajadores);
            Libreria.usuarios.put(Rol.Clientes, usuariosClientes);

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
