# Bucle while

# suma todos los numeros del 1 al 100
print("Suma de los numeros del 1 al 100")

suma = 0
num = 1

while num <= 100:
    suma += num
    num += 1

print("La suma total es ", suma)

# suma todos los numeros pares del 1 al 100

print("Suma de los numeros pares del 1 al 100")

suma = 0
num = 1

while num<=100:
    if num % 2 == 0:
        suma += num
    num += 1
print("La suma de pares es ", suma)

#suma todos los numeros impares del 1 al 100
print("Suma de los numeros impares del 1 al 100")

suma = 0
num = 1

while num<=100:
    if num % 2 != 0:
        suma += num
    num += 1
print("La suma de impares es ", suma)

# Cuantas veces se puede dividir un número entre 2 hasta que sea menor que 1?

print("Cuantas veces podrá dividirse entre 2?")

numero = int(input("Introduce un numero"))
contador = 0

while numero > 1:
    numero /= 2
    contador += 1
print("Se puede dividir ",contador," veces")


# Bucle que valida la entrada de un número positivo
numero = int(input("Ingresa un número: "))

while numero < 0:
    print("El numero debe ser positivo")
    numero = int(input("Ingresa un número"))

print("El numero ", numero, " es correcto")