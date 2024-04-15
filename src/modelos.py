from dataclasses import dataclass, field
from typing import List
from datetime import date

@dataclass
class Producto:
    nombre: str
    precio: float
    fecha_importacion: date
    numero_serie: str
    stock: int

    def agregar_stock(self, cantidad: int):
        self.stock += cantidad

    def eliminar_stock(self, cantidad: int):
        if self.stock >= cantidad:
            self.stock -= cantidad
        else:
            print("No hay suficiente stock para eliminar.")

    def detalles(self) -> str:
        return f"{self.nombre}, Precio: {self.precio}, Número de Serie: {self.numero_serie}, Stock: {self.stock}"

    def get_descripcion_especifica(self) -> str:
        raise NotImplementedError("Cada subclase debe implementar 'get_descripcion_especifica'.")

@dataclass
class Electrodomestico(Producto):
    voltaje: int
    garantia: int  # en meses

    def get_descripcion_especifica(self) -> str:
        return f"Voltaje: {self.voltaje} V, Garantía: {self.garantia} meses"

@dataclass
class Limpieza(Producto):
    componentes: str
    precauciones: str

    def get_descripcion_especifica(self) -> str:
        return f"Componentes: {self.componentes}, Precauciones: {self.precauciones}"

@dataclass
class Belleza(Producto):
    indicaciones: str
    efectos: str

    def get_descripcion_especifica(self) -> str:
        return f"Indicaciones: {self.indicaciones}, Efectos: {self.efectos}"

@dataclass
class Alimento(Producto):
    fecha_caducidad: date
    recomendaciones_nutricionales: str

    def get_descripcion_especifica(self) -> str:
        return f"Fecha de Caducidad: {self.fecha_caducidad}, Recomendaciones Nutricionales: {self.recomendaciones_nutricionales}"

@dataclass
class Cliente:
    nombre: str
    id: int
    compras: List[Producto] = field(default_factory=list)

    def añadir_producto(self, producto: Producto):
        self.compras.append(producto)

    def eliminar_producto(self, producto: Producto):
        if producto in self.compras:
            self.compras.remove(producto)

    def listar_productos_comprados(self):
        for producto in self.compras:
            print(producto.detalles() + ", " + producto.get_descripcion_especifica())
