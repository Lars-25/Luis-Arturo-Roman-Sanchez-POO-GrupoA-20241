package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Trabajador extends Usuario {
    private String rfc;
    private LocalDate fechaDeContratacion;
    private double salary;

    public Trabajador(String nombre, String apellido, Rol rol, String rfc, double salary, LocalDate fechaDeRegistro, LocalDate fechaDeContratacion, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.TRABAJADOR, fechaDeRegistro, contrasena, nombreUsuario);
        this.rfc = rfc;
        this.salary = salary;
        this.fechaDeContratacion = LocalDate.now();
    }
    
    @Override
    public String toString(){
        return String.format("%sRFC: %d\nFecha de contratación: %s\nSalario: $%.2f\n", super.toString(), this.rfc, this.fechaDeContratacion.toString(), this.salary);
    }

}