package Usuarios;

import Libreria.utils.DatosComun;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import Utils.EmpleadoUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import static Libreria.Libreria.usuarios;
import static Libreria.utils.DatosComun.obtenerDatosComun;

public class Gerente extends Usuario  implements EmpleadoUtils {

    private String curp;
    public Gerente(String nombre, String apellido, String curp, LocalDate fechaNacimiento, String numero, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.Gerente, fechaNacimiento,numero, contrasena, nombreUsuario);
        this.curp=curp;
    }

    @Override
    public void checarEntrada(){
        System.out.println("ENTRADA CON HUELLA");
    }

    @Override
    public void checarSalida(){
        System.out.println("SALIDA CON HUELLA");
    }

    public static void agregarGerente(){
        System.out.println("OPCION DE REGISTRAR UN GERENTE. ");
        Scanner leer= new Scanner(System.in);
        ArrayList<String> datosComun = obtenerDatosComun(Rol.Gerente);

        String nombre = datosComun.get(0);
        String apellido = datosComun.get(1);
        String telefono = datosComun.get(2);
        String nombreUsuario = datosComun.get(3);
        String contrasena = datosComun.get(4);


        LocalDate fecha = DatosComun.obtenerFechaNacimiento();

        System.out.println("Ingresa la curp: ");
        leer.nextLine();
        String curp = leer.nextLine();

        Gerente gerente = new Gerente(nombre,apellido,curp,fecha,telefono,contrasena,nombreUsuario);

        if (!usuarios.containsKey(Rol.Gerente)){
            usuarios.put(Rol.Gerente, new ArrayList<>()); // si es la primera vez q entra un cliente, crea el hashmap con la llave para acceder
            //como el rol y una arraylist que contendra a los clientes
        }

        usuarios.get(Rol.Gerente).add(gerente);
    }
    public static void mostrarGerente(Gerente gerente){
        System.out.printf("Gerente de nombre: %s %s. ID: %s. Fecha de nacimiento: %s CURP: %s",gerente.getNombre(),gerente.getApellido(),gerente.getId(),gerente.getFechaNacimineto(),gerente.getCurp());

    }

    public static void mostrarGerentes(){
        System.out.println("---MOSTRAR GERENTES---");
        for (Usuario user : usuarios.get(Rol.Gerente)){
            Gerente gerente= (Gerente) user;
            System.out.printf("Gerente de nombre: %s %s. ID: %s. Fecha de nacimiento: %s CURP: %s",gerente.getNombre(),gerente.getApellido(),gerente.getId(),gerente.getFechaNacimineto(),gerente.getCurp());

        }
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp){
        this.curp=curp;
    }
}
