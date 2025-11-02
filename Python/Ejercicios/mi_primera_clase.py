#Modelado de un objeto cotidiano.

#Creacion de la clase Persona
class Persona:
	#Definicion de los atributos
	def __init__(self,nombre,edad):
		self.nombre = nombre
		self.edad = edad
	#Los tipos de datos se definirán al crear la instancia de clase para respetar duck typing

	#Creacion de un metodo de clase por el cual imprimir el nombre por pantalla
	def presentarse(self):
		print(f'¡Hola! Mi nombre es {self.nombre}.')

#Instancia de la clase Persona
mi_persona = Persona("Helena", 16)
#Llamada al metodo desde la instancia
mi_persona.presentarse()

