# Creación de la clase PC
class PC:
    # Creación del metodo constructor donde se definen los atributos.
    def __init__(self, marca, modelo, procesador, memoria_ram,
                  almacenamientostatus):
        self.marca = str(marca) # Atributo marca tipo string.
        self.modelo = str(modelo) # Atributo modelo tipo string.
        self.procesador = int(procesador) # Atributo procesador tipo integer.
        self.memoria_ram = int(memoria_ram) # Atributo memoria_ram tipo integer.
        self.almacenamientostatus = int(almacenamientostatus) # Atributo almacenamientostatus tipo integer.

    # Creación del metodo install_app que crea el atributo app e imprime un mensaje de instalación.
    def install_app(self, app):
        self.app = app
        print("Se ha instalado la app", self.app)

# Instancias de la clase PC
portatil1 = PC("HP", "Spectre x360 14", 155, 32, 2000)
portatil2 = PC("Dell", "XPS 13 9310", 1185, 16, 512)
portatil3 = PC("Lenovo Thinkpad", "X1 Carbon Gen 10", 1260, 16,
               512)

# Llamada al metodo install_app desde la instancia
portatil1.install_app("Photoshop")
portatil2.install_app("Spotify")
portatil3.install_app("Figma")