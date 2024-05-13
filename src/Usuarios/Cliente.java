package Usuarios;

import Libreria.Libreria;
import Libreria.utils.DatosComun;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Libreria.Libreria.usuarios;
import static Libreria.utils.DatosComun.obtenerDatosComun;

public class Cliente extends Usuario {

    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido, LocalDate fechaNacimiento,String numero, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.Clientes, fechaNacimiento, numero, contrasena, nombreUsuario);
        this.fechaRegistro= LocalDate.now();//asigna la fecha actual a este atributo
    }

    public LocalDate getFechaRegistro(){
        return fechaRegistro;
    }

    public static void agregarCliente(){
        Scanner leer= new Scanner(System.in);
        System.out.println("HAS SELECCIONADO LA OPCION DE REGISTRAR UN CLIENTE. ");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.Clientes);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuarii = datosComun.get(3);
        String contraseñoa = datosComun.get(4);

        LocalDate fecha = DatosComun.obtenerFechaNacimiento();



        Cliente client = new Cliente(nombre,apellido,fecha,telefono,contraseñoa,nombreUsuarii);

        if (!usuarios.containsKey(Rol.Clientes)){
            usuarios.put(Rol.Clientes, new ArrayList<>()); // si es la primera vez q entra un cliente, crea el hashmap con la llave para acceder
            //como el rol y una arraylist que contendra a los clientes
        }

        usuarios.get(Rol.Clientes).add(client);

    }

    public static void mostrarClientes(){
        System.out.println("---MOSTRAR CLIENTES---");
        for (Usuario cliente : usuarios.get(Rol.Clientes)){
            Cliente clienteActual = (Cliente) cliente;
            System.out.println();
            System.out.printf("Cliente de nombre: %s %s. ID: %s Fecha de nacimiento: %s. Nombre de usuario: %s. Fecha de registro: %s", cliente.getNombre(),cliente.getApellido(),
                    cliente.getId(),cliente.getFechaNacimineto(),cliente.getNombreUsuario(),clienteActual.getFechaRegistro());
        }
    }

    public static void mostrarCliente(Cliente cliente){
        System.out.printf("Cliente de nombre: %s %s. ID: %s Fecha de nacimiento: %s. Nombre de usuario: %s. Fecha de registro: %s", cliente.getNombre(),cliente.getApellido(),
                cliente.getId(),cliente.getFechaNacimineto(),cliente.getNombreUsuario(),cliente.getFechaRegistro());
    }



    @Override
    public String toString(){
        return String.format("%s, fecha de registro: %s",super.toString(),fechaRegistro);
    }
}
