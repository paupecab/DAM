# -*- coding: utf-8 -*-
"""
Created on Wed Oct 16 13:05:28 2024

@author: paula
"""
#TIPOS DE DATOS EN PYTHON

# 1. probando dato tipo numero ENTERO INT
edad = 30
print(type(edad))

# 2. probando dato tipo FLOAT
altura = 1.57
print(type(altura))

# 2.1 probando dato tipo DOUBLE 
altura = 1.57 * 10**200
print(altura)
print(type(altura))
#responde tipo float. No existe en python

# 3. probando dato tipo COMPLEX
numero_complejo1 = complex(9,4)    
print(numero_complejo1)
print(type(numero_complejo1))

#operaciones con numero complejo
#declaracion de nuevas variables
numero_complejo2 = complex(3,2)
numero_complejo3 = complex(5,5)

#operaciones basicas con numeros complejos
suma = numero_complejo1 + numero_complejo2 + numero_complejo3
print(suma)
resta = numero_complejo1 - numero_complejo3
print(resta)
multiplicacion = numero_complejo2 * numero_complejo3
print(multiplicacion)
division = numero_complejo3 / numero_complejo2
print(division)

#accediendo a parte real
numero_complejo1 = complex(3,6)
parte_real1 = numero_complejo1.real
print(parte_real1)
print(type(parte_real1))
#devuelve el valor real en tipo float

#accediendo a parte imaginaria
parte_imag1 = numero_complejo1.imag
print(parte_imag1)
print(type(parte_imag1))
#devuelve el valor de la parte imaginaria en tipo float


# 4. probando dato tipo STRING
cadena1 = "Hello, world."
cadena2 = "It's me!"

print(cadena1)
print(cadena2)

#probando concatenación de datos string
concatenacion12 = cadena1 + ' ' + cadena2
print(concatenacion12)

#probando subcadenas
subcadena1 = cadena1[0:6]
subcadena21 = cadena2[4:7]
subcadena12 = cadena1[12]

print(subcadena1)
print(subcadena21)
print(subcadena12)

concatenacion = subcadena1 + '' + subcadena21 + '' + subcadena12
print(concatenacion)

#Modificando cadenas y creando Adele - "Hello, it's me"
cadena1_modificada = cadena1.replace("world","it's me")
print(cadena1_modificada)

# 5. probando dato de tipo ARRAY
# 5.1 Listas (list)
#las listas van entre parentesis cuadrados


#declaracion variables ingredientes
ingrediente1 = "leche"
ingrediente2 = "harina"
ingrediente3 = "azúcar"

#declarando el array
ingredientes = [ingrediente1, ingrediente2, ingrediente3]

print(ingredientes)

#realizando consultas de datos por su índice en el array
ingredientes[0]
ingredientes[1]
ingredientes[2]

#cambiando un elemento
ingredientes[0] = "crema"

#asignando una longitud específica al array
#definiendo variable que relaciona al array con funcion LEN
numero_ingredientes = len(ingredientes)

#asignando el valor de la variable que define la longitud
numero_ingredientes = 3
#siempre es 1 más de lo que se indica porque cuenta la posicion 0

#añadiendo un nuevo elemento con APPEND
ingredientes.append("sal")
ingredientes[3]
#el nuevo elemento se aloja al final

#eliminando un elemento con POP
#asignando nueva variable para relacionar funcion POP
tercero = ingredientes.pop(2)
print(tercero)

#añadiendo nuevo elemento
ingredientes.append("huevos")
print(ingredientes)

#eliminando un elemento con la funcion REMOVE
ingredientes.remove("crema")
print(ingredientes)

#creando estructura FOR IN
for ingrediente in ingredientes:
    print(ingrediente)


#creando un array distinto para probar estructura FOR IN
color1 = "cian"
color2 = "magenta"
color3 = "limón"
colores = [color1, color2, color3]

for color in colores:
    print(color)
    
edad1 = 54
edad2 = 51
edad3 = 26
edad4 = 16

familyAge = [edad1, edad2, edad3, edad4]


print(familyAge)

#creando bucle FOR IN
for edad in familyAge:
    print(edad)

# 5.2 TUPLAS (tuple)
# utilizan paréntesis normales

coordenadas = (3, 5)
colores_rgb = (255, 0, 0)

# 5.3 CONJUNTOS (set)
#colecciones desordenadas de elementos unicos
#no permiten datos duplicados y se definen encerrando
#los elementos entre llaves {} o utilizando la funcion set

numeros_primos = {2, 3, 5, 7, 11}
vocales = {"a", "o", "e", "i", "u"}


# 5.4 DICCIONARIOS (dict)
#colecciones desordenadas de pares clave-valor
#se puede acceder a los valores mediante una clave única
#se utiliza ": " entre clave y valor y ", " entre pares.

persona = {"nombre": "Helena", "edad": "16", "ciudad": "Madrid"}
punto = {"x": 3, "y": 5}


# 6. Datos tipo BOOLEANO (bool) AND, OR, XOR, NOT
luz1 = 3
luz2 = 0
luz3 = 0
luz4 = 100

print(luz1 > 0) 

x = True
y = False

print(luz1 and luz2 > 0) 
print(luz1 and luz4 > 0)
print(luz1 == 0) 

print((luz1 or luz1) > 0)

#datos tipo fecha y hora
import datetime #importar la librería

#Fecha: datetime.date(año, mes, día)
CumplePaula = datetime.date(1998, 9, 5)
CumpleHelena = datetime.date(2008, 6, 3)

print(CumplePaula)
print(CumpleHelena)

#con .month se accede al mes; con .day al día
print(CumpleHelena.month)
print(CumplePaula.day)

#.isoweekday muestra en número del día semanal (1-7)
CumpleHelena.isoweekday()
CumplePaula.isoweekday()

#Hora: datetime.time(hora, minuto, segundo)
HoraMiercoles = datetime.time(16, 25)
HoraJueves = datetime.time(17, 30)
SegundosRestantes = datetime.time(0, 0, 10)

#NoneType - ningun valor es valido, sin valor significativo

