#Programa que calcula edad a traves de conversión de tipos.
#Inicio

#Función edad_persona
def edad_persona (anio_actual, anio_nacimiento):
    total_edad = anio_actual - anio_nacimiento
    return total_edad

#Solicitar valores a usuario
#Conversión de tipos de input (string) -> int
anio_actual = int(input("Ingrese el año actual: "))
anio_nacimiento = int(input("Ingrese su año de nacimiento: "))

#Llamada a la función edad_persona
edad = edad_persona(anio_actual, anio_nacimiento)

#Mostrar edad por pantalla
print(f"Su edad es:{edad}")

