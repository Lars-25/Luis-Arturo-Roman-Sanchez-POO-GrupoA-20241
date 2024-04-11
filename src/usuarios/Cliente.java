package usuarios;
import java.time.LocalDate;

import usuarios.utils.Rol;

public class Cliente extends Usuario {
    private LocalDate fechaDeRegistro;

    public Cliente(String nombre, String apellido) {
        super(nombre, apellido, Rol.CLIENTE);
        this.fechaDeRegistro = LocalDate.now();
    }

    public LocalDate getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    @Override
    public String toString(){
        return String.format("%sFecha de Registro %s\n", super.toString(), fechaDeRegistro.toString());
    }
    
}