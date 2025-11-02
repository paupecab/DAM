from usuario import Usuario
from permiso import Permiso
from rol import Rol
from autenticacion import SistemaAutenticacion

# Creacion de permisos
permiso_crear = Permiso("crear_usuario") # Permiso para crear usuarios
permiso_eliminar = Permiso("eliminar_usuario") # Permiso para eliminarlos

# Creacion de un rol con estos permisos
rol_admin = Rol("admin")

# Asignación de permisos al rol
rol_admin.agregar_permiso(permiso_crear)
rol_admin.agregar_permiso(permiso_eliminar)

# Creacion de un usuario, clave y asignación de rol
# Nuevo usuario
usuario1 = Usuario("Michael", "Corleone", "michaelcorleone@email.com")
# Crear clave encriptada del usuario
usuario1.set_clave("laFamiglia1234")
# Asignación de rol administrador al usuario
usuario1.agregar_rol(rol_admin)

# Registro del usuario en el sistema de autenticación
# Instancia de SistemaAutenticación
sistema = SistemaAutenticacion()
# Registro del usuario en el sistema
sistema.registrar_usuario(usuario1)

# Prueba de autenticación
# Verificación de credenciales
print("¿Autenticado?", sistema.autenticar("michaelcorleone@email.com", "laFamiglia1234"))

# Prueba de permisos
# Verificación del usuario para eliminar usuarios del sistema
print("¿Tiene permiso para eliminar?", usuario1.tiene_permiso("eliminar_usuario"))
