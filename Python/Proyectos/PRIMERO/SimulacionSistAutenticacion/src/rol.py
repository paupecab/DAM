# Clase que representa un rol dentro del sistema.
# Cada rol tiene un nombre y una lista de permisos asociados.

from permiso import Permiso # para usarla en un metodo.

class Rol:
    def __init__(self, nombre):
        self.nombre = nombre
        self.permisos = []

    # Metodo que agrega un permiso al rol si aún no está en la lista.
    def agregar_permiso(self, permiso: Permiso):
        if permiso not in self.permisos:
            self.permisos.append(permiso)


