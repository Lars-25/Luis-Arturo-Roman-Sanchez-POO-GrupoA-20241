package Utils;

import Usuarios.Usuario;

public class UsuarioEnSesion {

    private static UsuarioEnSesion instancia;
    private static Usuario usuario;


    private UsuarioEnSesion(){

    }

    public static UsuarioEnSesion getInstancia(){
        if (instancia==null){
            instancia = new UsuarioEnSesion();
        }

        return instancia;
    }

    public static Usuario getUsuarioActual(){
        return usuario;
    }

    public void setUsuario(Usuario usuario){
        UsuarioEnSesion.usuario =usuario;
    }

    public boolean hayUssuario(){
        return usuario != null;
    }

    public void cerrarSesion(){
        usuario = null;
        instancia = null;
    }

}
