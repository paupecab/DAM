class Persona:
    #Constructor
    def __init__(self, edad):
        self.__edad = edad #atributo protegido

    #Getter
    @property
    def get_edad(self):
        return self.__edad

# Instancia de Persona con edad 30
persona1 = Persona(30)
# Llamada al Getter
print("La edad de esta persona es :",persona1.get_edad)


class Gatito:
    def __init__(self, nombre):
        self.__nombre = nombre # atributo protegido

    # Getter
    @property
    def get_nombre(self):
        return self.__nombre

gatito1 = Gatito("Buttercup") #Instanciación de la clase Gatito con nombre Buttercup
gatito2 = Gatito("Luna") #Instanciación de la clase Gatito con nombre Luna

print("nombres de los gatitos:")
print(gatito1.get_nombre, gatito2.get_nombre)

class Animal:
    def __init__(self, clase, tipo, sexo, nombre):
        self.__clase = clase
        self.__tipo = tipo
        self.__sexo = sexo
        self.__nombre = nombre

    @property
    def get_tipo(self): return self.__tipo
    @property
    def get_sexo(self): return self.__sexo
    @property
    def get_clase(self): return self.__clase
    @property
    def get_nombre(self): return self.__nombre

    def mostrar_animal(self):
        print("Animal de clase: ",self.get_clase, ", tipo: ",self.get_tipo,
              ", sexo: ",self.get_sexo," y nombre: ",self.get_nombre)

animal1 = Animal("reptil", "pogona dragón barbudo", "macho", "Cuco")
animal2 = Animal("felino", "gato negro embrujado", "hembra", "Luna")
animal3 = Animal("felino", "gato rubio afónico", "hembra", "Buttercup")

animal1.mostrar_animal()
animal2.mostrar_animal()
animal3.mostrar_animal()



