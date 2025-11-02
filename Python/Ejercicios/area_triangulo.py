#Calcula el area de un triangulo ingresando su base y altura.
#Condicional para verificar que los datos sean positivos.

#1. Introducción de valores y asignación a variables
baseTriangulo = float(input("Ingresa la base del triángulo: "))
alturaTriangulo = float(input("Ingresa la altura del triángulo: "))

#2. Estructura condicional para evitar que el área sea 0 o negativa
if  baseTriangulo < 0:
    baseTriangulo = -baseTriangulo
elif alturaTriangulo <0:
    alturaTriangulo = -alturaTriangulo
elif baseTriangulo == 0 or alturaTriangulo == 0 :
    print("Los datos introducidos no corresponden a un triangulo sino a una línea.")

#3. Calcular area
areaTriangulo = (baseTriangulo * alturaTriangulo)/2
print(f"El area del triángulo es {areaTriangulo}")




