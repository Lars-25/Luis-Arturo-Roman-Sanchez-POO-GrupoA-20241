package usuarios;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private double salario;
    private String rfc;
    private String curp;

    public Gerente(String nombre, String apellido, Rol rol, String curp, String rfc, double salario, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.GERENTE, fechaRegistro, fechaNacimiento, numeroTelefono, contrasena, nombreUsuario);
        this.curp = curp;
        this.rfc = rfc;
        this.salario = salario;
    }

    @Override
    public String toString(){
        return String.format("%sCURP: %s\nRFC: %s\nFecha de contratación: %s\nSalario: $%.2f\n", super.toString(), this.curp, this.rfc, this.getFechaRegistro().toString(), this.salario);
    }

    public String getCurp() {
        return curp;
    }

    public String getRfc() {
        return rfc;
    }

    public double getSalario(){
        return salario;
    }

    
}
