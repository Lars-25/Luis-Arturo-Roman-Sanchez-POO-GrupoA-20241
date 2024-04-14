package Sistema;
import java.util.ArrayList;
import Usuarios.*;

public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public Usuario verificarInicioSesion(String nombreUsuario, String contrasena) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;  // retorna null si no encuentra usuario
    }

    public boolean registrarCliente(String nombre, String apellido, String nombreUsuario, String contrasena) {
        if (buscarUsuarioPorNombreUsuario(nombreUsuario) == null) {  // Verifica que el nombre de usuario no exista
            Cliente nuevoCliente = new Cliente(nombre, apellido, nombreUsuario, contrasena);
            agregarUsuario(nuevoCliente);
            return true;
        }
        return false;
    }

    public boolean registrarTrabajador(String nombre, String apellido, String nombreUsuario, String contrasena, double salario) {
        if (buscarUsuarioPorNombreUsuario(nombreUsuario) == null) {
            Trabajador nuevoTrabajador = new Trabajador(nombre, apellido, nombreUsuario, contrasena, salario);
            agregarUsuario(nuevoTrabajador);
            return true;
        }
        return false;
    }

    public boolean registrarGerente(String nombre, String apellido, String nombreUsuario, String contrasena, double salario) {
        if (buscarUsuarioPorNombreUsuario(nombreUsuario) == null) {
            Gerente nuevoGerente = new Gerente(nombre, apellido, nombreUsuario, contrasena, salario);
            agregarUsuario(nuevoGerente);
            return true;
        }
        return false;
    }

    private Usuario buscarUsuarioPorNombreUsuario(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}
