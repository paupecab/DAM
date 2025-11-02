# En este archivo se crea la clase base Persona.
# Representa una persona genérica con nombre y apellido.
# Se usa como clase padre para heredar en otras clases (por ejemplo, 'Usuario').
class Persona:
    def __init__(self, nombre, apellido):
        # Atributos privados: no deben modificarse directamente desde fuera de la clase.
        self._nombre = nombre
        self._apellido = apellido

    # Getter del atributo _nombre.
    # Permite acceder al nombre como si fuera un atributo público: persona.nombre
    @property
    def nombre(self):
        return self._nombre

    # Setter para cambiar el valor del atributo _nombre.
    # Permite asignar un nuevo valor de forma controlada: persona.nombre = "Paula"
    @nombre.setter
    def nombre(self, valor):
        self._nombre = valor

    # Getter para obtener el valor del atributo _apellido.
    @property
    def apellido(self):
        return self._apellido

    # Setter para cambiar el valor del atributo _apellido.
    @apellido.setter
    def apellido(self, valor):
        self._apellido = valor
