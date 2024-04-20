package usuarios;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Trabajador extends Usuario {
    private String rfc;
    private double salario;


    public Trabajador(String nombre, String apellido, Rol rol, String rfc, double salario, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.TRABAJADOR, fechaRegistro, fechaNacimiento, numeroTelefono, contrasena, nombreUsuario);
        this.rfc = rfc;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return String.format("%sRFC: %s\nFecha de contratación: %s\nSalario: $%.2f\n", super.toString(), this.rfc, this.getFechaRegistro().toString(), this.salario);
    }

    public String getRfc() {
        return rfc;
    }

    public double getSalario(){
        return salario;
    }

    
}
