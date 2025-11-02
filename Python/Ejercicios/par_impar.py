#Indicar si un numero introducido por pantalla es par o impar

#1. Introducción de valores y asignación a variables enteras
numero = int(input("Introduzca un numero entero: "))
#el numero debe ser entero

#2. Estructura condicional que verifica si es par o impar
if numero % 2 == 0:
    print(f"El numero {numero} es par")
else:
    print(f"El numero {numero} es impar")

