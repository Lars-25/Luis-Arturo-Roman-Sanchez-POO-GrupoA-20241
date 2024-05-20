package Models;

import Usuarios.Trabajador;
import Usuarios.Cliente;
import Usuarios.Gerente;

import java.util.ArrayList;

public class UsuarioModel {
    ArrayList<Gerente> gerentes = new ArrayList<>();
    ArrayList<Trabajador> trabajadores = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();

    public ArrayList<Gerente> getGerentes() {
        return gerentes;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
}
