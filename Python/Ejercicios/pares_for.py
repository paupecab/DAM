# Imprimir números pares del 1 al 20 con FOR

for numero in range(2,21,2): # Los números del rango incrementan de 2 en 2
    print(numero) # Imprime todos los números de la secuencia.

for numero in range(1,21):
    if numero % 2 == 0: # Con estructura condicional, validando los pares.
        print(numero) # Imprime solo los números pares.


for numero in range(1,21):
    if numero % 2 != 0: # Con estructura condicional, validando los impares.
        continue # Con la sentencia continue salta a la siguiente iteración
    print(numero) # Imprime solo numeros pares


