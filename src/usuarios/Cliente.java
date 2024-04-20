package usuarios;
import usuarios.utils.Rol;
import java.time.LocalDate;

public class Cliente extends Usuario {
    private String curp;
    
    public Cliente(String nombre, String apellido, Rol rol, String curp, LocalDate fechaRegistro, LocalDate fechaNacimiento, String numeroTelefono, String contrasena, String nombreUsuario) {
        super(nombre, apellido, Rol.CLIENTE, fechaRegistro, fechaNacimiento, numeroTelefono, contrasena, nombreUsuario);
        this.curp = curp;
    }

    @Override
    public String toString(){
        return String.format("%sCURP: %s\nFecha de Registro: %s\n", super.toString(), this.curp, this.getFechaRegistro().toString());
    }

    public String getCurp() {
        return curp;
    }
    
}
