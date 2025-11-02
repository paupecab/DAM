#Calcula un periodo en meses siempre que sea superior a 10 años.

#Constante.
PLAZO_MINIMO = 10

#Función que convierte un número de años en meses.
#Parámetro: numero_anyos (int) -> número de años a convertir.
#Retorno: (int) -> total.
def calcular_periodo(numero_anyos: int) -> int:
    #Constante que indica el número de meses que tiene un año.
    MESES_POR_ANYO = 12

    #Cálculo total de meses.
    total_periodo = numero_anyos * MESES_POR_ANYO

    return total_periodo

#Solicitud al usuario para que introduzca una cantidad de años.
cantidad = int(input("Introduce cantidad de años:"))

#Bloque de control que verifica si la cantidad introducida es suficiente.
if cantidad < PLAZO_MINIMO:
    #Si la cantidad es menor que el plazo mínimo, se muestra mensaje de error.
    print("La cantidad de años es insuficiente")

else:
    #Si la cantidad es válida, se calcula el periodo en meses y se muestra.
    periodo = calcular_periodo(cantidad)

    print(periodo)