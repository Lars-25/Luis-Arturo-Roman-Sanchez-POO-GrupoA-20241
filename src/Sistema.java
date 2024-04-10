import java.util.Scanner;

public class Sistema {
    private final String CONTRASENA_SEGURA = "H1/m";
    private Scanner scanner = new Scanner(System.in);
    private Tienda tienda = new Tienda();

    public void ejecutarPrograma() {
        boolean esContrasenaValida = false;

        do {
            System.out.println("\n*** BIENVENIDO ***");
            System.out.println("Ingresa la contraseña");
            String contrasena = scanner.nextLine();

            if (contrasena.equals(CONTRASENA_SEGURA)) {
                esContrasenaValida = true;
                ejecutarMenuSistema();
            } else {
                System.out.println("\nContraserna incorrecta, intenta de nuevo");
            }
        } while (!esContrasenaValida);
    }

    private void ejecutarMenuSistema() {
        int opcion = 0;

        do {
            System.out.println("\n** BIENVENIDO AL SISTEMA **");
            System.out.println("1. Registrar Producto");
            System.out.println("2. Registrar Cliente");
            System.out.println("3. Mostrar Productos");
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Eliminar Producto");
            System.out.println("6. Eliminar Cliente");
            System.out.println("7. Anadir a stock");
            System.out.println("8. Eliminar del stock");
            System.out.println("9. Realizar compra");
            System.out.println("10. Ver compras");
            System.out.println("11. Salir");

            switch (opcion) {
                case 1:
                    System.out.println("\nSeleccionaste Registrar Producto");
                    System.out.println("Ingresa el tipo de producto");
                    System.out.println("1. Limpieza");
                    System.out.println("2. Alimento");
                    System.out.println("3. Electrodomestico");
                    System.out.println("4. Maquillaje");
                    System.out.println("Selecciona una opción");
                    int opcionProcucto = scanner.nextInt();

                    switch (opcionProcucto) {
                        case 1:
                            tienda.registrarProductoLimpieza();
                            break;
                        case 2:
                            tienda.registrarProductoAlimento();
                            break;
                    }

                    break;
            }
        } while(opcion != 11);
    }
}