package Libreria;

import Libreria.Libros.Constantes.Genero;
import Libreria.Libros.Libro;
import Libreria.Libros.LibroAccion;
import Libreria.Libros.LibroComedia;
import Libreria.Libros.LibroTerror;
import Serializers.LibroDeserializer;
import Serializers.LibroSerializer;
import Serializers.UsuarioDeserializer;
import Serializers.UsuarioSerializer;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;
import java.util.*;

public class Libreria {
    @SuppressWarnings("RawTypes")
    public static HashMap<Rol,ArrayList<Usuario>> usuarios = new HashMap<>();
    public static HashMap<Genero,ArrayList<Libro>> libros = new HashMap<>();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public Libreria (){
        inicializarLlaves();
    }

    private void inicializarLlaves(){
        usuarios.put(Rol.Trabajador,new ArrayList<>());
        usuarios.put(Rol.Clientes,new ArrayList<>());
        usuarios.put(Rol.Gerente,new ArrayList<>());

        libros.put(Genero.Terror,new ArrayList<>());
        libros.put(Genero.Accion,new ArrayList<>());
        libros.put(Genero.Comedia,new ArrayList<>());
    }

    public void mostrarTodosLibros(){
        Libro.mostrarTodosLibros();
    }

    public void eliminarLibroAccion(){
        LibroAccion.eliminarLibro();
    }

    public void eliminarLibroComedia(){
        LibroComedia.eliminarLibro();
    }

    public void eliminarLibroTerror(){
        LibroTerror.eliminarLibro();
    }

    public void registrarTerror(){
        LibroTerror.registrarLibroTerror();
    }

    public void registrarComedia(){
        LibroComedia.registrarLibroComedia();
    }

    public void registrarAccion(){
        LibroAccion.registrarLibroAccion();
    }



    public  Usuario verificarInicioSesion(String nombreusuario, String contrasena) {
        Collection<ArrayList<Usuario>> usuariosCollection = usuarios.values();
        for (ArrayList<Usuario> usuariosLista : usuariosCollection) {
            for (Usuario usuario : usuariosLista) {
                if (usuario.getNombreUsuario().equals(nombreusuario)) {
                    if (usuario.getContrasena().equals(contrasena)) {
                        return usuario;
                    }
                }
            }
        }
        return null;
    }

    public void registrarUsuario(Usuario usuario) {
        usuarios.get(usuario.getRol()).add(usuario);
    }

    public boolean nombreUsuarioExistente(String nombreUsuario) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean numeroTelefonoExistente(String numeroTelefono) {
        for (ArrayList<Usuario> listaUsuarios : usuarios.values()) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNumeroTelefono().equals(numeroTelefono)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void eliminarUsuario(Usuario usuario){
        Usuario.eliminarUsuario(usuario);
    }


    public void agregarCliente(){
        Cliente.agregarCliente();
    }

    public void agregarTrabajador(){
        Trabajador.agregarTrabajador();
    }

    public void agregarGerente(){
        Gerente.agregarGerente();
    }

    public void actualizarInfo(Usuario user){
        Usuario.actualizarDatosComun(user);
    }

    public void mostrarUsuarios(){
        Usuario.mostrarUsuarios();
    }

    public void mostrarNombreUsuario(){
        Trabajador.mostrarNombreUsuario();
    }


    public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
        Usuario ejemplo =Usuario.getUsuarioPorNombreUsuario(nombreUsuario);
        return ejemplo;
    }

    public void mostrarClientes(){
        Cliente.mostrarClientes();
    }

    public void mostrarTrabajadores (){
        Trabajador.mostrarTrabajadores();

    }



    public void mostrarGerente(Gerente gerente){
        Gerente.mostrarGerente(gerente);
    }

    public void mostrarTrabajador (Trabajador trabajador){
        Trabajador.mostrarTrabajador(trabajador);
    }

    public void mostrarCliente(Cliente cliente){
        Cliente.mostrarCliente(cliente);
    }


    public void mostrarUsuario (Usuario usuario){
        Usuario.mostrarUsuario(usuario);
    }

    public void guardarJson(){
        LibroSerializer.LibroSerializer();
        UsuarioSerializer.UsuarioSerializer();
    }

    public void leerJson(){
        LibroDeserializer.LibroDeserealizer();
        UsuarioDeserializer.UsuarioDeserializer();
    }

}
