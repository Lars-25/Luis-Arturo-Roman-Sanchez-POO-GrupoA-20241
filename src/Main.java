import Libreria.Libreria;
import Libreria.Menu;
import Usuarios.Gerente;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Libreria libreria= new Libreria();
        Menu menu= new Menu(libreria);

        Menu.mostrarMenu();

    }
}