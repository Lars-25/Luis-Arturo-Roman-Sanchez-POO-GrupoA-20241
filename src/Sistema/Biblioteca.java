package Sistema;
import java.util.ArrayList;
import Usuarios.*;

public class Biblioteca {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Trabajador> trabajadores = new ArrayList<>();


    public void agregarUsuario(Usuario usuario){
        this.usuarios.add(usuario);
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
}