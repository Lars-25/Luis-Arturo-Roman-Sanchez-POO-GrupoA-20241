package usuarios;

import usuarios.utils.Rol;

public class Usuario {
    private static int nextID = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;

    public Usuario(String nombre, String apellido, Rol rol) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.id = nextID;
        nextID++;
    }

    @Override
    public String toString(){
        return String.format("ID: %d\nNombre completo: %s %s\nRol: %s\n", id, nombre, apellido, rol);
    }

}