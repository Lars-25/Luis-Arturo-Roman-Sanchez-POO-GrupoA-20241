package Utils;

import Usuarios.Usuario;

public class UsuarioEnSesion {

    /*
    MUST- Registro de cliente, trabajador y gerente, y consulta de ellos
    MUST- Consulta de todos los usuarios, consulta de un usuario individual
    NICE TO HAVE- Tratar de implementar el inicio de sesion con el SINGLETON
     */


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
