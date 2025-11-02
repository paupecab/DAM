# Representa un permiso individual, como 'crear_usuario'.
# Se usará para asociar permisos a roles.
class Permiso:
    def __init__(self, nombre):
        self.nombre = nombre