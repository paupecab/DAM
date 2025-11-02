# -*- coding: utf-8 -*-
"""
Created on Mon Oct 21 13:30:46 2024

@author: paula
"""

#Algoritmos de ordenamiento

#Ordenamiento rápido o quicksort
#Segun sean mayores o menores que el elemento que estemos
#usando como referencia, elegimos un elemento del conjunto
#el pivote, y movemos el resto de los elementos a cada uno
#de sus lados. El subconjunto esta sujeto al mismo proceso

#Importamos un Metodo de la biblioteca random para generar 
#listas aleatorias
from random import sample

#creamos la lista base con numeros del 1 al 100
lista = list(range(100))

#lista aleatoria con sample
#8 elementos aleatorios de la lista base
vectorquick = sample(lista, 8)

#introduccion de la funcion QUICKSORT que ordena el vector
#que se le entregue como argumento con el Metodo Quick Sort
def quicksort(vectorquick):
    #Imprimimos la lista desordenada obtenida al principio
    print("El vector a ordenar con quick es: ", vectorquick)
    
    def quick(vectorquick, start = 0, end = len(vectorquick) - 1):
        if start >= end:
            return
        
        def particion(vectorquick, start=0, end=len(vectorquick) -1):
            pivot = vectorquick[start]
            menor = start + 1
            mayor = end
        
            while True:
            #si el valor actual es mayor que el pivot está em el lugar
            #correcto (lado derecho del pivot) y podemos movernos hacia
            #la izquierda, al siguiente elemento.
            #También debemos asegurarnos de no haber superado el puntero
            #bajo, ya que indica que ya hemos movido todos los elementos
            #a su lado correcto del pivot
                while menor <= mayor and vectorquick[mayor] >= pivot:
                    mayor = mayor - 1
            #proceso opuesto al anterior
                while menor <= mayor and vectorquick[menor] <= pivot: 
                    menor = menor + 1
            #encontramos un valor, sea mayor o menor, y que esté fuera del 
            #arreglo, o menor es más grande que mayor, en cuyo caso salimos
            #del ciclo
                if menor <= mayor:
                    vectorquick[menor], vectorquick[mayor] = vectorquick[mayor],
                    vectorquick[menor]                
                #continúa el bucle
                else:
                    break
                #sal del bucle
        
                vectorquick[start], vectorquick[mayor] = vectorquick[mayor], 
                vectorquick[start]
        
            return mayor
        p = particion(vectorquick, start, end)
        quick(vectorquick, start, p - 1)
        quick(vectorquick, p + 1, end)

    quick(vectorquick)
    print("El vector ordenado con quick es: ", vectorquick)
            
quicksort(vectorquick)
