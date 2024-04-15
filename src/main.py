from controladores import TiendaControlador


class Autenticacion:
    @staticmethod
    def verificar_acceso():
        password_correcta = "HASPHASSWORD"
        intentos = 3
        while intentos > 0:
            contraseña = input("Ingrese la contraseña para acceder al sistema: ")
            if contraseña == password_correcta:
                print("Acceso concedido.\n")
                return True
            intentos -= 1
            print(f"Contraseña incorrecta. {intentos} intentos restantes.")
        print("Acceso denegado.")
        return False

def main():
    if not Autenticacion.verificar_acceso():
        return
    
    controlador = TiendaControlador()
    while True:
        print("\nSeleccione una opción:")
        print("1. Registrar producto")
        print("2. Registrar cliente")
        print("3. Mostrar productos")
        print("4. Mostrar clientes")
        print("5. Eliminar producto")
        print("6. Eliminar cliente")
        print("7. Añadir a Stock")
        print("8. Eliminar del Stock")
        print("9. Realizar una compra")
        print("10. Ver compras")
        print("11. Salir")

        opcion = input("Opción: ")

        if opcion == "11":
            print("Saliendo...")
            break

        if opcion == "1":
            controlador.registrar_producto()
        elif opcion == "2":
            controlador.registrar_cliente()
        elif opcion == "3":
            controlador.mostrar_productos()
        elif opcion == "4":
            controlador.mostrar_clientes()
        elif opcion == "5":
            controlador.eliminar_producto()
        elif opcion == "6":
            controlador.eliminar_cliente()
        elif opcion == "7":
            controlador.añadir_stock()
        elif opcion == "8":
            controlador.eliminar_del_stock()
        elif opcion == "9":
            controlador.realizar_compra()
        elif opcion == "10":
            controlador.ver_compras()
        else:
            print("Opción no válida, por favor intente de nuevo.")

if __name__ == "__main__":
    main()
