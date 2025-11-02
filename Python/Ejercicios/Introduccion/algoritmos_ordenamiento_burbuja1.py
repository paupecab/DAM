# -*- coding: utf-8 -*-
"""
Created on Thu Oct 17 13:17:42 2024

@author: paula
"""

#Algoritmos de ordenacion

#Ordenamiento de burbuja: compara cada elemento de la lista que
#se ordenara con el elemento que le sigue y, si es necesario, invierte
#el orden de los elementos. La lista completa se examina varias
#veces después de que se decida que no se requieren más cambios.

#importamos un Metodo de la biblioteca random para generar
#listas aleatorias
from random import sample

#Creamos la lista base con numeros del 1 al 100
lista = list(range(100))

#Creamos una lista aleatoria con sample
#8 elementos aleatorios de la lista base
vectorbs = sample(lista, 8)

#introduciendo funcion BUBBLESORT: ordenara el vector
#que se le ofrezca como argumento con el Metodo Bubble Sort
def bubblesort(vectorbs) :
    #imprimimos la lista obtenida al principio, desordenada
    print("El vector a ordenar es:", vectorbs)
    #declaramos una variable contador del largo del vector
    n = 0
    
    #bucle for in para contar la cantidad de caracteres en vectorbs
    for _ in vectorbs:
        n += 1
        
    #le damos un rango n para que complete el proceso
    for i in range(n-1):
        #revisa la matriz de 0 hasta n-i-1
        for j in range(0, n - i - 1):
            #Se intercambian si el elemento encontrado es mayor
            #Luego pasa al siguiente
            if vectorbs[j] > vectorbs[j + 1]:
                vectorbs[j], vectorbs[j + 1] = vectorbs[j + 1], vectorbs[j]
    print("El vector ordenado es: ", vectorbs)

bubblesort(vectorbs)

            