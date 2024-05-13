package Usuarios;

import Libreria.Libreria;
import Usuarios.utils.Rol;
import Utils.UsuarioEnSesion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static Libreria.Libreria.usuarios;

public class Usuario {
    private static int CANTIDAD_USARIOS = 1;
    private int id;
    private  String nombre;
    private String apellido;
    private Rol rol;
    private LocalDate fechaNacimineto;
    private String contrasena;
    private String nombreUsuario;
    private String numeroTelefono;

    public Usuario(String nombre, String apellido, Rol rol, LocalDate fechaNacimiento,String numeroTelefono, String contrasena, String nombreUsuario) {
        this.id= CANTIDAD_USARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimineto = fechaNacimiento;
        this.numeroTelefono=numeroTelefono;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        CANTIDAD_USARIOS++;
    }
    @Override
    public String toString(){
        return String.format("ID %d, Nombre completo: %s %s, rol %s", id,nombre,apellido,rol);
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimineto() {
        return fechaNacimineto;
    }

    public String getNumeroTelefono(){
        return numeroTelefono;
    }

    public static void eliminarUsuario(Usuario usuario){
        if (UsuarioEnSesion.getUsuarioActual().getNombreUsuario().equals(usuario.getNombreUsuario())){
            System.out.println("NO SE PUEDE ELIMINAR EL USUARIO QUE ESTA EN SESION");
        }
        else{
            ArrayList<Usuario> listaUsuarios = usuarios.get(usuario.getRol());
            if (listaUsuarios != null) {
                listaUsuarios.remove(usuario);
                System.out.println("USUARIO ELIMINADO CORRECTAMENTE. ");
            }
        }

    }

    public static void mostrarUsuarios(){
        Collection<ArrayList<Usuario>> usuariosCollection = usuarios.values();
        System.out.println("---MOSTRAR A TODOS LOS USUARIOS---");
        for (ArrayList<Usuario> usuariosLista : usuariosCollection){
            for (Usuario usuario : usuariosLista){
                System.out.println();
                System.out.printf("Usuario de nombre: %s %s. ROL: %s ID: %s Fecha de nacimiento: %s. Nombre de usuario: %s \n",usuario.getNombre(),usuario.getApellido(),usuario.getRol()
                        ,usuario.getId(),usuario.getFechaNacimineto(),usuario.getNombreUsuario());
            }

        }
    }

    public static void mostrarNombreUsuario(){
        Collection<ArrayList<Usuario>> usuariosCollection = usuarios.values();
        System.out.println("---NOMBRES DE USUARIO---");
        for (ArrayList<Usuario> usuariosLista : usuariosCollection){
            for (Usuario usuario : usuariosLista){
                System.out.println();
                System.out.printf("Nombre de usuario: %s \n",usuario.getNombreUsuario());
            }
        }
    }

    public static Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
        Collection<ArrayList<Usuario>> usuariosCollection = usuarios.values();
        for (ArrayList<Usuario> usuariosLista : usuariosCollection) {
            for (Usuario usuario : usuariosLista) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    return usuario;
                }
            }
        }
        return null;
    }

    public static void actualizarDatosComun(Usuario user){
        Scanner leer = new Scanner(System.in);
        String opcion = "";
        Rol rol= user.getRol();
        do {
            System.out.println("Que caracteristica quieres cambiar: ");
            System.out.println("1. Nombre ");
            System.out.println("2. Apellido ");
            System.out.println("3. Numero ");
            System.out.println("4. Contraseña");
            String rolActual = rol == Rol.Trabajador ? "CAMBIAR RFC": rol == Rol.Gerente ? "CAMBIAR CURP" : "OPCION NO VALIDA PARA CLIENTE ";
            System.out.println("5."+rolActual);
            System.out.println("6. SALIR");
            opcion=leer.nextLine();

            if (opcion.equals("1")) {
                System.out.println("Ingresa el nuevo nombre: ");
                String newNombre = leer.nextLine();
                user.setNombre(newNombre);
                System.out.println("CAMBIADO CORRECTAMENTE. ");
            } else if (opcion.equals("2")) {
                System.out.println("Ingresa el nuevo apellido: ");
                String newApellido = leer.nextLine();
                user.setApellido(newApellido);
                System.out.println("CAMBIADO CORRECTAMENTE. ");
            } else if (opcion.equals("3")) {
                System.out.println("Ingresa el nuevo numero: ");
                String newnum= user.obtenerNumeroTelefono();
                user.setNumero(newnum);
                System.out.println("CAMBIADO CORRECTAMENTE. ");
            } else if (opcion.equals("4")) {
                System.out.println("Ingresa la nueva contrasena: ");
                String newContrasena = leer.nextLine();
                user.setContrasena(newContrasena);
                System.out.println("CAMBIADO CORRECTAMENTE. ");
            } else if (opcion.equals("5")) {
                if (rol == Rol.Trabajador) {
                    System.out.println("Ingresa el nuevo RFC: ");
                    String newRFC = leer.nextLine();
                    Trabajador worker = (Trabajador) user;
                    worker.setRfc(newRFC);
                    System.out.println("CAMBIADO CORRECTAMENTE. ");
                } else if (rol == Rol.Gerente) {
                    System.out.println("Ingresa el nuevo CURP: ");
                    String newCurp = leer.nextLine();
                    Gerente ger = (Gerente) user;
                    ger.setCurp(newCurp);
                    System.out.println("CAMBIADO CORRECTAMENTE. ");
                } else if (rol == Rol.Clientes) {
                    System.out.println("OPCION NO VALIDA PARA CLIENTE");
                }
            } else if (opcion.equals("6")) {
                System.out.println("SALIENDO");
                break;
            }


        } while (true);

    }

    public void setNombre(String name){
        nombre = name;
    }

    public void setApellido(String last){
        apellido = last;
    }

    public void setNumero(String n){
        numeroTelefono = n;
    }

    public void setContrasena(String pass){
        contrasena = pass;
    }

    private String obtenerNumeroTelefono() {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente;
        String telefono;
        Collection<ArrayList<Usuario>> usuariosCollection = Libreria.usuarios.values(); //obtenemos la coleccion de todos llos dato
        do {
            System.out.println("Ingresa el nuevo número de teléfono");
            telefono = scanner.nextLine();
            numeroExistente = false;
            for (ArrayList<Usuario> usuariosLista : usuariosCollection) {
                for (Usuario usuario : usuariosLista) {
                    if (usuario.getNumeroTelefono().equals(telefono)) {
                        numeroExistente = true;
                        break;
                    }
                }
            }
            if (numeroExistente) {
                System.out.println("El número ya existe. Inténtalo de nuevo\n");
            }
        } while (numeroExistente);
        return telefono;
    }

    public static void mostrarUsuario (Usuario usuario){
        System.out.println();
        System.out.printf("Usuario de nombre: %s %s. ROL: %s ID: %s Fecha de nacimiento: %s. Nombre de usuario: %s \n",usuario.getNombre(),usuario.getApellido(),usuario.getRol()
                ,usuario.getId(),usuario.getFechaNacimineto(),usuario.getNombreUsuario());
    }

}
