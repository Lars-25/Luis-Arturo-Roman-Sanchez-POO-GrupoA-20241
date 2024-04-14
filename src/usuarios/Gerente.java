package Usuarios;

import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private String curp;
    private double salary;
    private String rfc;
    private LocalDate fechaDeAsenso;

    public Gerente(String nombre, String apellido, Rol rol, String rfc, double salary, String curp, LocalDate fechaDeAsenso, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.GERENTE, fechaDeRegistro, contrasena, nombreUsuario);
        this.salary = salary;
        this.rfc = rfc;
        this.fechaDeAsenso = LocalDate.now();
    }

    @Override
    public String toString(){
        return String.format("Salario: %.2f\nRFC: %d\nFecha de asenso: %s", super.toString(), this.salary, this.rfc, this.fechaDeAsenso.toString());
    }

}