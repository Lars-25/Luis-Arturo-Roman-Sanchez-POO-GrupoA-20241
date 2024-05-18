package Usuarios;

import Libreria.utils.DatosComun;
import Usuarios.utils.Rol;
import Utils.EmpleadoUtils;

import javax.swing.plaf.PanelUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Libreria.Libreria.usuarios;
import static Libreria.utils.DatosComun.obtenerDatosComun;

public class Trabajador extends Usuario implements EmpleadoUtils {

    private String rfc;

    public Trabajador(String nombre, String apellido,  String rfc, LocalDate fechaNacimiento, String numeroTel, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.Trabajador, fechaNacimiento, numeroTel, contrasena, nombreUsuario);
        this.rfc=rfc;
    }

    public String getRfc() {
        return rfc;
    }

    @Override
    public void checarEntrada(){
        System.out.println("ENTRADA CON CORREO");
    }

    @Override
    public void checarSalida(){
        System.out.println("SALIDA CON CORREO");
    }

    public static void agregarTrabajador(){
        Scanner leer= new Scanner(System.in);
        System.out.println("HAS SELECCIONADO LA OPCION DE REGISTRAR UN TRABAJADOR. ");
        ArrayList<String> datosComun = obtenerDatosComun(Rol.Trabajador);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);


        LocalDate fecha = DatosComun.obtenerFechaNacimiento();

        System.out.println("Finalmente, ingresa su RFC: ");
        String rfc= leer.nextLine();

        Trabajador trabajador = new Trabajador(nombre,apellido,rfc,fecha,telefono,contrasena,nombreUsuario);

        if (!usuarios.containsKey(Rol.Trabajador)){
            usuarios.put(Rol.Trabajador, new ArrayList<>()); // si es la primera vez q entra un cliente, crea el hashmap con la llave para acceder
            //como el rol y una arraylist que contendra a los clientes
        }



        usuarios.get(Rol.Trabajador).add(trabajador);

    }
    public static void mostrarTrabajadores (){
        System.out.println("---MOSTRAR TRABAJADORES---");
        for (Usuario trabajador : usuarios.get(Rol.Trabajador)){
            Trabajador trabajadorActual = (Trabajador) trabajador;
            System.out.println();
            System.out.printf("Trabajador de nombre: %s %s. ID: %s Fecha de nacimiento: %s. Nombre de usuario: %s. RFC: %s",trabajador.getNombre(),trabajador.getApellido(),
                    trabajador.getId(),trabajador.getFechaNacimineto(),trabajador.getNombreUsuario(),trabajadorActual.getRfc());
        }
    }

    public static void mostrarTrabajador (Trabajador trabajador){
        System.out.printf("Trabajador de nombre: %s %s. ID: %s Fecha de nacimiento: %s. Nombre de usuario: %s. RFC: %s",trabajador.getNombre(),trabajador.getApellido(),
                trabajador.getId(),trabajador.getFechaNacimineto(),trabajador.getNombreUsuario(),trabajador.getRfc());
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

}
