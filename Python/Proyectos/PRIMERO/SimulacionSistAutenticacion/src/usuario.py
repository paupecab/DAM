import bcrypt # para encriptar claves
from base_persona import Persona # clase padre
from rol import Rol # lista de roles

# Clase Usuario hereda de Persona y representa a un usuario del sistema.
# Gestiona la autenticación y los roles asociados, cada uno con permiso.
class Usuario(Persona):
    def __init__(self, nombre, apellido, correo_electronico):
        # Llamada al superconstructor
        super().__init__(nombre,apellido)

        # Correo electrónico del usuario (privado)
        self.__correo_electronico = correo_electronico

        # Contraseña encriptada del usuario (se establece con set_clave)
        self.__clave = None

        # Lista de roles que tiene el usuario
        self.roles = []

    # Getter del correo electrónico
    @property
    def correo_electronico(self):
        return self.__correo_electronico

    # Setter del correo electrónico
    @correo_electronico.setter
    def correo_electronico(self, correo):
        self.__correo_electronico = correo

    # Setter de la clave
    # Recibe una clave plana en texto (flat_password)
    # La guarda encriptada con bcrypt.
    def set_clave(self, clave):
        self.__clave = bcrypt.hashpw(clave.encode(), bcrypt.gensalt())

    # Metodo para verificar si la contraseña introducida coincide con la almacenada.
    # Devolverá True si la contraseña es correcta, False si no lo es.
    def verificar_clave(self, clave_introducida):
        return bcrypt.checkpw(clave_introducida.encode(), self.__clave)

    # Metodo que añade un rol al usuario si no lo tiene ya.
    def agregar_rol(self, rol : Rol):
        if rol not in self.roles:
            self.roles.append(rol)

    # Metodo que verifica si el usuario tiene un permiso específico
    # revisando los permisos de todos sus roles.
    def tiene_permiso(self, nombre_permiso):
        for rol in self.roles:
            for permiso in rol.permisos:
                if permiso.nombre == nombre_permiso:
                    return True
        return False

