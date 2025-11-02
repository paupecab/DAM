class Animal:
    def __init__(self, tipo, color, caracteristica, humor, nombre):
        self.__nombre = nombre
        self.__tipo = tipo
        self.__color = color
        self.__caracteristica = caracteristica
        self.__humor = humor

    @property
    def caracteristica(self):
        return self.__caracteristica

    # Setter para el atributo caracteristica
    @caracteristica.setter
    def caracteristica(self, caracteristica):
        self.__caracteristica = caracteristica

    @property
    def nombre(self):
        return self.__nombre

    #Setter para el atributo nombre
    @nombre.setter
    def nombre(self, nombre):
        self.__nombre = nombre

    @property
    def color(self):
        return self.__color

    # Setter para el atributo color
    @color.setter
    def color(self, color):
        self.__color = color

    @property
    def tipo(self):
        return self.__tipo

    # Setter para el atributo tipo
    @tipo.setter
    def tipo(self, tipo):
        self.__tipo = tipo

    @property
    def humor(self):
        return self.__humor

    # Setter para el atributo humor
    @humor.setter
    def humor(self, humor):
        self.__humor = humor

    def mostrar_animal(self):
        print("Animal de nombre: ",self.nombre, ", tipo: ",self.tipo,
              ", caracteristica: ",self.caracteristica,", color: ",self.color,
              " y de humor: ",self.humor)

animal1 = Animal("desconocido","desconocido", "desconocido", "desconocido", "desconocido")

animal1.color = "terroso"
animal1.humor = "cascarrabias"
animal1.nombre = "Cuco"
animal1.tipo = "lagarto"
animal1.caracteristica = "barbudo"

animal1.mostrar_animal()