from modelos import *
from datetime import date
from typing import List

class TiendaControlador:
    def __init__(self):
        self.productos: List[Producto] = []
        self.electrodomesticos: List[Electrodomestico] = []
        self.productos_limpieza: List[Limpieza] = []
        self.productos_belleza: List[Belleza] = []
        self.alimentos: List[Alimento] = []
        self.clientes: List[Cliente] = []

    def registrar_producto(self):
        tipo = int(input("Ingrese tipo de producto (1-Electrodomestico, 2-Limpieza, 3-Belleza, 4-Alimento): "))
        
        nombre = input("Ingrese nombre: ")
        precio = float(input("Ingrese precio: "))
        numero_serie = input("Ingrese número de serie: ")
        stock = int(input("Ingrese stock inicial: "))
        fecha_importacion = date.today()

        if tipo == 1:
            voltaje = int(input("Ingrese voltaje: "))
            garantia = int(input("Ingrese garantía (meses): "))
            producto = Electrodomestico(nombre, precio, fecha_importacion, numero_serie, stock, voltaje, garantia)
            self.electrodomesticos.append(producto)
        elif tipo == 2:
            componentes = input("Ingrese componentes: ")
            precauciones = input("Ingrese precauciones: ")
            producto = Limpieza(nombre, precio, fecha_importacion, numero_serie, stock, componentes, precauciones)
            self.productos_limpieza.append(producto)
        elif tipo == 3:
            indicaciones = input("Ingrese indicaciones: ")
            efectos = input("Ingrese efectos: ")
            producto = Belleza(nombre, precio, fecha_importacion, numero_serie, stock, indicaciones, efectos)
            self.productos_belleza.append(producto)
        elif tipo == 4:
            fecha_caducidad = input("Ingrese fecha de caducidad (YYYY-MM-DD): ")
            recomendaciones = input("Ingrese recomendaciones nutricionales: ")
            fecha_caducidad_date = date.fromisoformat(fecha_caducidad)
            producto = Alimento(nombre, precio, fecha_importacion, numero_serie, stock, fecha_caducidad_date, recomendaciones)
            self.alimentos.append(producto)
        else:
            print("Tipo de producto no válido")
            return

        self.productos.append(producto)
        print("Producto registrado con éxito.")

    def registrar_cliente(self):
        nombre = input("Ingrese nombre del cliente: ")
        id_cliente = int(input("Ingrese ID del cliente: "))
        cliente = Cliente(nombre, id_cliente)
        self.clientes.append(cliente)
        print("Cliente registrado con éxito.")

    def mostrar_productos(self):
        if not self.productos:
            print("No hay productos registrados.")
            return
        for producto in self.productos:
            print(producto.detalles() + ", " + producto.get_descripcion_especifica())

    def mostrar_clientes(self):
        if not self.clientes:
            print("No hay clientes registrados.")
            return
        for cliente in self.clientes:
            print(f"ID: {cliente.id}, Nombre: {cliente.nombre}")

    def eliminar_producto(self):
        num_serie = input("Ingrese el número de serie del producto a eliminar:")
        for producto in self.productos:
            if producto.numero_serie == num_serie and producto.stock == 0:
                self.productos.remove(producto)
                print("Producto eliminado correctamente.")
                return
        print("Producto no encontrado o stock no es 0.")

    def eliminar_cliente(self):
        id_cliente = int(input("Ingrese el ID del cliente a eliminar:"))
        for cliente in self.clientes:
            if cliente.id == id_cliente and not cliente.compras:
                self.clientes.remove(cliente)
                print("Cliente eliminado correctamente.")
                return
        print("Cliente no encontrado o tiene compras.")

    def añadir_stock(self):
        num_serie = input("Ingrese el número de serie del producto para añadir stock:")
        cantidad = int(input("Ingrese la cantidad de stock a añadir:"))
        for producto in self.productos:
            if producto.numero_serie == num_serie:
                producto.agregar_stock(cantidad)
                print("Stock añadido correctamente.")
                return
        print("Número de serie no encontrado.")

    def eliminar_del_stock(self):
        num_serie = input("Ingrese el número de serie del producto para eliminar del stock:")
        cantidad = int(input("Ingrese la cantidad de stock a eliminar:"))
        for producto in self.productos:
            if producto.numero_serie == num_serie:
                if producto.stock >= cantidad:
                    producto.eliminar_stock(cantidad)
                    print("Stock eliminado correctamente.")
                    return
                else:
                    print("No hay suficiente stock para eliminar la cantidad solicitada.")
                    return
        print("Número de serie no encontrado o cantidad incorrecta.")

    def realizar_compra(self):
        id_cliente = int(input("Ingrese el ID del cliente:"))
        num_serie = input("Ingrese el número de serie del producto a comprar:")

        cliente = next((c for c in self.clientes if c.id == id_cliente), None)
        producto = next((p for p in self.productos if p.numero_serie == num_serie and p.stock > 0), None)

        if not cliente:
            print("Cliente no encontrado.")
            return
        if not producto:
            print("Producto no disponible para la compra.")
            return

        producto.eliminar_stock(1)
        cliente.añadir_producto(producto)
        print("Compra realizada con éxito.")

    def ver_compras(self):
        id_cliente = int(input("Ingrese el ID del cliente para ver sus compras:"))
        cliente = next((c for c in self.clientes if c.id == id_cliente), None)

        if not cliente:
            print("Cliente no encontrado.")
            return

        if not cliente.compras:
            print("Este cliente no ha realizado compras.")
            return

        print(f"Productos comprados por {cliente.nombre}:")
        cliente.listar_productos_comprados()
