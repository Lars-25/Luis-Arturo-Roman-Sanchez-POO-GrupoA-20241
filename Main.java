import usuarios.Cliente;
import usuarios.Gerente;
import usuarios.Trabajador;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Luis", "Ramirez");
        Gerente gerente = new Gerente("Rodrigo", "Herrera", "Administrador", 55200, 123456789);
        Trabajador trabajador = new Trabajador("Lucas", "Morales", 135791357, 23000);

        System.out.println("\n"+cliente.toString()+"\n");
        System.out.println(gerente.toString()+"\n");
        System.out.println(trabajador.toString()+"\n");
    }
}