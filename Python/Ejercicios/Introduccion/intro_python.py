firstWords = "hello world"
suma = 0 + 1
resta = 10 - 10

print(firstWords, suma, resta, resta, suma, suma, suma, resta)

PI = 3.1416

nombre, apellido1, apellido2 = "Paula", "Pérez", "Cabañas"

print(apellido1, nombre)
print(nombre, apellido2)

edad = 25
flotante = 25.9

type(edad)

type(flotante)

edad_2 = "30"

edad + edad_2
type(float(edad))
type(int(flotante))

float(edad_2) + edad
int(edad_2) + edad

str(edad)

int(nombre)

print(1 == 2)

print(edad == 25)

type(1 == 1)

#BOOLIANOS: devuelve el valor true/false
bool(0)
#el unico booliano falso es el 0
bool(1)
bool(8)
bool(-1)

edad = "hello world"

print(edad)

edad = 12
print(edad)


edad = "true"

print(edad)


vacio = None
print(type(vacio))


edad_usuario = int(input("por favor, escribe tu edad: "))
print(type(edad_usuario))

#OPERADORES MATEMATICOS: +, -, *, /, //, %
edad = 25
tiempo_transcurrido = 5

edad_actual = edad - tiempo_transcurrido
print(edad_actual)

#exponentes
edad_potencial = edad_actual**2
print(edad_potencial)


#para realizar raices se utiliza el exponente con el resultado de la fracion

raiz_cuadrada = 16**0.5
raiz_cubica = 8**(1/3)
print(raiz_cuadrada)
print(raiz_cubica)

#funcion mod: devuelve el resto de una division entre dividendo y divisor
#por ejemplo: 5 % 2 devuelve 1, porque es el resto de la division entera

print(5 % 2)

print(edad % tiempo_transcurrido)

#el cociente de la division entera es el resultado del operador //
print(5//2)
print(9//4)
print(51//7)


#OPERADORES LÓGICOS: and, or, not
#and: ambas proposiciones deben ser ciertas
# ==: principio de identidad
(1==2) and (2==2)
(2==2) and (1==1)

#or: sera true si una de ellas es verdadera
(1==1) or (bool(0))
(1==8) or (2==8)

#not: cambia el valor booliano al opuesto
not (1==1) 
not (2==3)
not True 
not False

#COMPARACIONES: <, >, =, !=
(1 < 3)
(3 > 8)
(3 >= 3)
(1 <= 5)
(edad != tiempo_transcurrido)

#para asignar un nuevo valor a una variable mediante una operacion se 
#utiliza *= +=,-=, etc.

edad *= 5
print(edad)