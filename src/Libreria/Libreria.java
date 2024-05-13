package Libreria;
import Libreria.Libros.Constantes.Genero;
import Libreria.Libros.Libro;
import Libreria.Libros.LibroAccion;
import Libreria.Libros.LibroComedia;
import Libreria.Libros.LibroTerror;
import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.*;

public class Libreria {
    @SuppressWarnings("RawTypes")
    public static HashMap<Rol,ArrayList<Usuario>> usuarios = new HashMap<>(); //el rol es la llave, el arraylist es el valor que se le da a cada llave
    public static HashMap<Genero,ArrayList<Libro>> libros = new HashMap<>();


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




}
