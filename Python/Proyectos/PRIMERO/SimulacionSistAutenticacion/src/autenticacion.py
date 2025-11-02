from usuario import Usuario

# Clase que representa un sistema de autenticación.
# Permite registrar usuarios y comprobar si sus credenciales son correctas.
class SistemaAutenticacion:
    def __init__(self):
        # Lista que almacena los usuarios registrados en el sistema.
        self.usuarios = []

    # Metodo que registra un nuevo usuario en el sistema.
    # Recibe un objeto Usuario y lo añade a la lista de usuarios.
    def registrar_usuario(self, usuario: Usuario):
        self.usuarios.append(usuario)

    # Metodo que verifica si hay un usuario con el correo y contraseña correcta.
    # Recibe un correo electrónico y una contraseña en texto plano.
    # Devuelve True si hay un usuario con ese correo y la contraseña es correcta.
    def autenticar(self, correo, clave):
        for usuario in self.usuarios:
            if usuario.correo_electronico == correo:
                if usuario.verificar_clave(clave):
                    return True
        # Devuelve False si no hay coincidencia o la contraseña es incorrecta.
        return False