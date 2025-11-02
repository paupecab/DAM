# Bucle for

print("Cuantas veces se ejecuta un bucle for en el rango de 0 a 5?")
contador = 0
for i in range (0, 5):
    print(i)
    contador += 1
print("Se ejecuta", contador, "veces") #Se ejecuta 5 veces

print("Cuantas veces se ejecuta un bucle for en el rango de 2020 a 2025?")
contador = 0
for year in range (2020, 2025):
    print("Informes de ", year)
    contador += 1
print("Se ejecuta ", contador, "veces") #Se ejecuta 5 veces


#imprimir todas las frutas del frutero
print("Imprimir todos los strings de un array.")
frutero = ["manzana", "pomelo", "plátano", "uva", "pera"]
for fruta in frutero:
    print(fruta)

#Hacer una suma de numeros del 1 al 10
print("Sumar los numeros del 1 al 10.")
suma = 0

for numero in range(0, 10):
    suma += numero
print("La suma es", suma)

print("Texto en diagonal:")
string = "Hello, world."
espacio = "  "
for caracter in string:
    print(espacio,caracter)
    espacio += "  "


#visualización de los elementos de una matriz con bucles for anidados
print("Elementos de una matriz con bucles anidados:")
matriz = [[-5,2,0],[9,5,6],[1,7,15]]
print("Matriz 1: todos los elementos")
for i in matriz:
    for j in i:
        print(j)

print("Matriz 2: hasta llegar al elemento con valor 1")

for i in matriz:
    for j in i:
        print(j)
        if j == 1:
            break #Se aplica una condición para introducir break que interrumpe el bucle

print("Matriz 3: recorre las filas")
for fila in matriz:
    print(fila)

print("Matriz 4: salta el elemento con valor 9")
for i in matriz:
    for j in i:
        #Se aplica una condición para introducir continue que salta ese elemento
        if j == 9:
            continue
        print(j)
