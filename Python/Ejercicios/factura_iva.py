# -*- coding: utf-8 -*-
"""
Created on Tue Oct 22 11:31:27 2024

@author: paula
"""

#Ejercicio 1
#Creacion de un programa que calcule el total de una factura
#tras aplicarle el IVA.
#Tomar el importe sin IVA y el porcentaje de IVA a aplicar
#Devolver el valor total de la factura.


importesinIVA = float(input("Ingresa el importe sin IVA de"
                            " tu factura: "))
IVA = float(input("Ingresa el porcentaje de IVA para aplicar a"
                  " tu factura: "))

importeTotal = ((importesinIVA*IVA)/100) + importesinIVA

print(f"El valor total de la factura con un {IVA}% de IVA"
      f" será {importeTotal}.")


#Ahora vamos a llamar a una función que aplica el IVA a una
#factura
#Si se llama a la función sin que se le pase un porcentaje
#de IVA, se descontará el 21%

#ALGORITMO O INSTRUCCIONES DE PROCESAMIENTO DE LOS DATOS DE ENTRADA
def invoice(amount, vat=21):
    #parámetros: amount es la cantidad sin IVA, vat es el % de IVA
    #esta función devuelve el total de la factura una vez aplicado
    #el IVA
    return amount + amount*vat/100

#ENTRADA DE DATOS DEL PROGRAMA
print(invoice(1000,10)) #ejecucion del programa con IVA diferente
print(invoice(1000)) #ejecucion con IVA 21%

#salida de datos por pantalla


#Vamos a hacer lo mismo, solicitando entrada del valor factura
#por un usuario, con IVA 21%

def invoice(amount, vat=21):
    return amount + amount*vat/100

valor_inicial = float(input("Ingresa valor factura: "))

print(f"el valor inicial es {valor_inicial}")
print("el valor despues de IVA es ")
print(invoice(valor_inicial))