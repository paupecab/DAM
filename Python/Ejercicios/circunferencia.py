# -*- coding: utf-8 -*-
"""
Created on Mon Oct 21 14:03:21 2024

@author: paula
"""

# Creacion de algoritmo
# Calcular circunferencia de un número

# cargar librería donde se detalla el valor de la cte PI
# el valor puede venir de cualquier lugar

import math
diametro = float(input("Ingresa el diámetro de tu circunferencia"))

circunferencia = diametro * math.pi
radio = diametro / 2
area = math.pi * radio ** 2

print(f"la circunferencia es {circunferencia}, el radio es {radio}" 
f" y el área es {area}")
